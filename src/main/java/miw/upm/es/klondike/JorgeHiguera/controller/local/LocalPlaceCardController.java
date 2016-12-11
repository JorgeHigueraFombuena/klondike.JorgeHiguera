package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalPlaceCardController extends LocalMoveCardContoller 
implements PlaceCardController {

	public LocalPlaceCardController(Game game) {
		super(game);
	}	

	@Override
	public Error faceUpPermited(Card toFaceUp) {
		if(toFaceUp != null && toFaceUp.isFaceDown()){
			return null;
		}
		return Error.MOVEMENT_NOT_PERMITED;
	}

}
