package miw.upm.es.klondike.controller;

public interface MoveFromStrightToSuitController extends PlaceCardController {

	Error move(int originStright);
	
}
