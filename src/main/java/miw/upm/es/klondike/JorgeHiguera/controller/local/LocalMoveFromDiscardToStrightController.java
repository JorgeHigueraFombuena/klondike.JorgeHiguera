package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public class LocalMoveFromDiscardToStrightController extends LocalPlaceCardController
		implements MoveFromDiscardToStrightController {

	public LocalMoveFromDiscardToStrightController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public Error isStrightCorrect(int stright, Card card) {
		
		return null;
	}

	@Override
	public Error move(int targetStright) {
		Card placed = super.getFirstCardFromStright(targetStright);
		Card toPlace = super.getFirstCardFromDiscard();
		Error error = super.movedPermited(toPlace, placed);
		if(error == null){
			super.move(toPlace, targetStright);
		}
		return error;
	}

}
