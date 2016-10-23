package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromStrightToSuitController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public class LocalMoveFromStrightToSuitController extends LocalPlaceCardController
		implements MoveFromStrightToSuitController {

	public LocalMoveFromStrightToSuitController(Game game) {
		super(game);
	}

	@Override
	public Error isStrightCorrect(int stright, Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Error move(int originStright) {
		Card toPlace = super.getFirstCardFromStright(originStright);
		Card placed = super.getFirstCardFromSuit(toPlace);
		Error error = super.movedPermited(toPlace, placed, PlaceOfCard.SUIT);
		if(error == null){
			super.moveFromStrightToSuit(originStright);
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		// TODO Auto-generated method stub

	}

}
