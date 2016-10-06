package miw.upm.es.klondike.JorgeHiguera.controller;

public interface MovementControllerVisitor {

	void visit(MovementStrightController movementStrightController);
	
	void visit(MovementSuitController movementSuitController);
	
}
