package miw.upm.es.klondike.JorgeHiguera.controller;

public interface MoveFromStrightToStrightController extends PlaceCardController {

	Error move(int originStright, int targetStright);
	
}
