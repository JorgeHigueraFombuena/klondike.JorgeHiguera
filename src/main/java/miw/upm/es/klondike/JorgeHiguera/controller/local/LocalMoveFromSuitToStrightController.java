package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromSuitToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public class LocalMoveFromSuitToStrightController extends LocalPlaceCardController
		implements MoveFromSuitToStrightController {

	public LocalMoveFromSuitToStrightController(Game game) {
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
	public Error move(Suit originSuit, int targetStright) {
		Card toPlace = super.getFirstCardFromSuit(originSuit);
		Card placed = super.getFirstCardFromStright(targetStright);
		Error error = super.movedPermited(toPlace, placed, PlaceOfCard.STRIGHT);
		if(error == null){
			super.moveFromSuitToStright(originSuit, targetStright);
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
