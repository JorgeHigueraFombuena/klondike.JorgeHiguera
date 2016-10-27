package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public interface MoveFromSuitToStrightController extends PlaceCardController {

	Error move(Suit originSuit, int targetStright);
	
}
