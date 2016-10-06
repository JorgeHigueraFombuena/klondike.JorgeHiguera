package miw.upm.es.klondike.JorgeHiguera.controller;

public interface MovementController {
	
	int getOriginStright();
	
	int getTargetStright();
	
	int getOriginSuit();
	
	void accept(MovementControllerVisitor movementControllerVisitor);

}