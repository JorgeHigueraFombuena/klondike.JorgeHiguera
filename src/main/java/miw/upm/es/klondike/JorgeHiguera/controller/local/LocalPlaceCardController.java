package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;

import java.util.List;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public abstract class LocalPlaceCardController extends LocalOperationController 
implements PlaceCardController {

	public LocalPlaceCardController(Game game) {
		super(game);
	}	

	@Override
	public Error movedPermited(Card toPlace, Card placed){
		if(placed == null && toPlace.isKing()){
			return null;
		}
		else if(placed.getPlaceOfCard() == PlaceOfCard.STRIGHT
				&& placed.getNumber() - toPlace.getNumber() == 1
				&& !placed.getSuit().equals(toPlace.getSuit())){
			return null;
		}
		else if(placed.getPlaceOfCard() == PlaceOfCard.SUIT
				&& placed.getNumber() - toPlace.getNumber() == 1
				&& placed.getSuit().equals(toPlace.getSuit())){
			return null;
		}
		return Error.MOVEMENT_NOT_PERMITED;
	}
	
}
