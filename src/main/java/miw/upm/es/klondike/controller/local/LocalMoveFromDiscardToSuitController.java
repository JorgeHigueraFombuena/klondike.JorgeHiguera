package miw.upm.es.klondike.controller.local;

import java.util.ArrayList;
import java.util.List;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveFromDiscardToSuitController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public class LocalMoveFromDiscardToSuitController extends LocalPlaceCardController
implements MoveFromDiscardToSuitController {

	public LocalMoveFromDiscardToSuitController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move() {
		Error error = movedPermited();
		if (error == null) {
			Card toPlace = super.getFirstCardFromDiscard();
			Card placed = super.getFirstCardFromSuit(toPlace.getSuit());
			List<Card> toPlaceCards = new ArrayList<Card>();
			List<Card> placedCards = new ArrayList<Card>();
			if (toPlace != null) {
				toPlaceCards.add(toPlace);
			}
			if (placed != null) {
				placedCards.add(placed);
			}
			error = super.movedPermited(toPlaceCards, placedCards, PlaceOfCard.SUIT);
			if (error == null) {
				super.moveFromDiscardToSuit(toPlace);
			}
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public Error movedPermited() {
		return super.validateEmptyDiscard() == Error.DISCARD_EMPTY ? Error.DISCARD_EMPTY : null;
	}

}
