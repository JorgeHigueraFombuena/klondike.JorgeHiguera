package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public interface PlaceCardController extends MoveCardController{

	public Error faceUpPermited(Card toFaceUp);
	
}
