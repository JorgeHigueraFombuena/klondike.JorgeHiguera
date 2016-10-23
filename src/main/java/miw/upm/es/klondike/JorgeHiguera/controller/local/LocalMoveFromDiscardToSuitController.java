package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToSuitController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public class LocalMoveFromDiscardToSuitController extends LocalPlaceCardController
		implements MoveFromDiscardToSuitController {

	public LocalMoveFromDiscardToSuitController(Game game) {
		super(game);
	}

	@Override
	public Error isStrightCorrect(int stright, Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move() {
		Card toPlace = super.getFirstCardFromDiscard();
		Card placed = super.getFirstCardFromSuit(toPlace);
		Error error = super.movedPermited(toPlace, placed, PlaceOfCard.SUIT);
		if(error == null){
			super.moveFromDiscardToSuit(toPlace);
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
