package miw.upm.es.klondike.controller;

public interface MovePilesController extends MoveCardController {

	Error move();

	Error movedPermited();

}
