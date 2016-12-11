package miw.upm.es.klondike.controller.local;

import java.util.ArrayList;
import java.util.List;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveFromStrightToSuitController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public class LocalMoveFromStrightToSuitController extends LocalPlaceCardController
		implements MoveFromStrightToSuitController {

	public LocalMoveFromStrightToSuitController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move(int originStright) {
		Card toPlace = super.getFirstCardOfStright(originStright);
		Card placed = super.getFirstCardFromSuit(toPlace.getSuit());
		List<Card> toPlaceCards = new ArrayList<Card>();
		List<Card> placedCards = new ArrayList<Card>();
		if(toPlace != null){
			toPlaceCards.add(toPlace);
		}
		if(placed != null){
			placedCards.add(placed);
		}
		Error error = super.movedPermited(toPlaceCards, placedCards, PlaceOfCard.SUIT);
		if(error == null){
			super.moveFromStrightToSuit(originStright);
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
