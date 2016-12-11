package miw.upm.es.klondike.controller;

public interface MoveFromDiscardToStrightController extends PlaceCardController {

	Error move(int targetStright);

}
