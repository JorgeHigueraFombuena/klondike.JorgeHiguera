package miw.upm.es.klondike.JorgeHiguera.controller.local;

import java.util.ArrayList;
import java.util.List;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToSuitController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public class LocalMoveFromDiscardToSuitController extends LocalMoveCardContoller
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
		Card toPlace = super.getFirstCardFromDiscard();
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
			super.moveFromDiscardToSuit(toPlace);
		}
		else {
			super.askOption();
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
