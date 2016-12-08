package miw.upm.es.klondike.JorgeHiguera.controller.local;

import java.util.ArrayList;
import java.util.List;

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
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move(Suit originSuit, int targetStright) {
		Card toPlace = super.getFirstCardFromSuit(originSuit);
		Card placed = super.getFirstCardOfStright(targetStright);
		List<Card> toPlaceCards = new ArrayList<Card>();
		List<Card> placedCards = new ArrayList<Card>();
		if(toPlace != null){
			toPlaceCards.add(toPlace);
		}
		if(placed != null){
			placedCards.add(placed);
		}
		Error error = super.movedPermited(toPlaceCards, placedCards, PlaceOfCard.STRIGHT);
		if(error == null){
			super.moveFromSuitToStright(originSuit, targetStright);
		}
		else{
			super.askOption();
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
