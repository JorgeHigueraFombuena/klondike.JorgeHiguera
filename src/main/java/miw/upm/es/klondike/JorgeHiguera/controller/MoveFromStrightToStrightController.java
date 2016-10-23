package miw.upm.es.klondike.JorgeHiguera.controller;

public interface MoveFromStrightToStrightController extends MoveCardStrightController {

	Error move(int originStright, int targetStright);
	
}
