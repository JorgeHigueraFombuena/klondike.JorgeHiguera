package miw.upm.es.klondike.JorgeHiguera.controller.local;

import java.util.List;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromStrightToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public class LocalMoveFromStrightToStrightController extends LocalPlaceCardController
		implements MoveFromStrightToStrightController {

	public LocalMoveFromStrightToStrightController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move(int originStright, int targetStright) {
		List<Card> placedCards = super.getFaceUpCardsOfStright(targetStright);
		List<Card> toPlaceCards =super.getFaceUpCardsOfStright(originStright);
		
		Error error = super.movedPermited(toPlaceCards, placedCards, PlaceOfCard.STRIGHT);
		if(error == null){
			super.moveFromStrightToStright(originStright, targetStright);
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
