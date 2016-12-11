package miw.upm.es.klondike.controller;

public interface MoveFromStrightToStrightController extends PlaceCardController {

	Error move(int originStright, int targetStright);
	
}
