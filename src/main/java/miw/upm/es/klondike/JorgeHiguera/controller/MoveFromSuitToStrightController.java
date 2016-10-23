package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public interface MoveFromSuitToStrightController extends MoveCardStrightController {

	Error move(Suit originSuit, int targetStright);
	
}
