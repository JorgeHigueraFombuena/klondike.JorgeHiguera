package miw.upm.es.klondike.controller;

import miw.upm.es.klondike.model.Suit;

public interface MoveFromSuitToStrightController extends PlaceCardController {

	Error move(Suit originSuit, int targetStright);

}
