package miw.upm.es.klondike.JorgeHiguera.controller.local;

import java.util.List;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveCardController;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

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
		for(Card toPlace : toPlaceCards){
			switch (targetPlace) {
			case SUIT:
				if(placed == null && toPlace.isAce()){
					return null;
				}
				else if(placed != null && toPlace.getSuit().equals(placed.getSuit())
						&& toPlace.getNumber() - placed.getNumber() == 1){
					return null;
				}
				break;

			case STRIGHT:
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
				break;

			default:
				return Error.MOVEMENT_NOT_PERMITED;
			}
		}
		return Error.MOVEMENT_NOT_PERMITED;
	}
	
	@Override
	public boolean gameFinished(){
		return super.gameFinished();
	}

}
