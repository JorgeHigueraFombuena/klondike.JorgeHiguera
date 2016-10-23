package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;

import java.util.List;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public abstract class LocalPlaceCardController extends LocalOperationController 
implements PlaceCardController {

	public LocalPlaceCardController(Game game) {
		super(game);
	}	

	@Override
	public Error movedPermited(Card toPlace, Card placed, PlaceOfCard targetPlace){
		if(targetPlace == PlaceOfCard.SUIT){
			if(placed == null && toPlace.isAce()){
				return null;
			}
			else if(placed != null && toPlace.getSuit().equals(placed.getSuit())
					&& placed.getNumber() - toPlace.getNumber() == 1){
				return null;
			}
		}
		else if(targetPlace == PlaceOfCard.STRIGHT){
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
		}
		return Error.MOVEMENT_NOT_PERMITED;
	}

	public Error faceUpPermited(Card toFaceUp) {
		if(toFaceUp != null && toFaceUp.isFaceDown()){
			return null;
		}
		return Error.MOVEMENT_NOT_PERMITED;
	}

}
