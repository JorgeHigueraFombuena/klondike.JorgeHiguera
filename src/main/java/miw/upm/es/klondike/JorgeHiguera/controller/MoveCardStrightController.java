package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Card;

public interface MoveCardStrightController extends PlaceCardController {

	Error isStrightCorrect(int stright, Card card);
	
}
