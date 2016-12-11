package miw.upm.es.klondike.controller;

import miw.upm.es.klondike.model.Card;

public interface PlaceCardController extends MoveCardController{

	public Error faceUpPermited(Card toFaceUp);
	
}
