package miw.upm.es.klondike.controller.local;

import java.util.List;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveCardController;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public abstract class LocalMoveCardContoller extends LocalOperationController implements MoveCardController {

	public LocalMoveCardContoller(Game game) {
		super(game);
	}

	@Override
	public Error movedPermited(List<Card> toPlaceCards, List<Card> placedCards, PlaceOfCard targetPlace){
		if(toPlaceCards.isEmpty() && placedCards.isEmpty()){
			return Error.MOVEMENT_NOT_PERMITED;
		}
		Card placed = placedCards == null || placedCards.isEmpty() ? null : placedCards.get(placedCards.size() - 1);
		Error error = Error.MOVEMENT_NOT_PERMITED;
		switch (targetPlace) {
		case SUIT:
			error = movedPermitedToSuitLoop(placed, toPlaceCards);
			break;
		case STRIGHT:
			error = movedPermitedToStrightLoop(placed, toPlaceCards);
			break;
		default:
			error = Error.MOVEMENT_NOT_PERMITED;
		}
		return error;
	}

	private Error movedPermitedToSuitLoop(Card placed, List<Card> toPlaceCards){
		Error error = Error.MOVEMENT_NOT_PERMITED;
		int i = 0;
		boolean found = false;
		while(i < toPlaceCards.size() && !found){
			Card toPlace = toPlaceCards.get(i);
			if(movedPermitedToSuit(placed, toPlace) == null){
				found = true;
			}
			i++;
		}
		return found ? null : error;
	}

	private Error movedPermitedToSuit(Card placed, Card toPlace){
		if(placed == null && toPlace.isAce()){
			return null;
		}
		else if(placed != null && toPlace.getSuit().equals(placed.getSuit())
				&& toPlace.getNumber() - placed.getNumber() == 1){
			return null;
		}
		else {
			return Error.MOVEMENT_NOT_PERMITED;
		}
	}

	private Error movedPermitedToStrightLoop(Card placed, List<Card> toPlaceCards){
		Error error = Error.MOVEMENT_NOT_PERMITED;
		int i = 0;
		boolean found = false;
		while(i < toPlaceCards.size() && !found){
			Card toPlace = toPlaceCards.get(i);
			if(movedPermitedToStright(placed, toPlace) == null){
				found = true;
			}
			i++;
		}
		return found ? null : error;
	}
	
	private Error movedPermitedToStright(Card placed, Card toPlace){
		if(placed == null && toPlace.isKing()){
			return null;
		}
		else if(placed != null && placed.isFaceDown() && toPlace.isKing()){
			return null;
		}
		else if(placed != null && !toPlace.getSuit().equals(placed.getSuit())
				&& placed.getNumber() - toPlace.getNumber() == 1){
			return null;
		}
		else {
			return Error.MOVEMENT_NOT_PERMITED;
		}
	}

	@Override
	public boolean gameFinished(){
		return super.gameFinished();
	}

	@Override
	public void finishTheGame(){
		super.finishTheGame();
	}

}
