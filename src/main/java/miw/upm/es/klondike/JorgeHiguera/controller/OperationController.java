package miw.upm.es.klondike.JorgeHiguera.controller;

public interface OperationController {

	void accept(OperationControllerVisitor operationalControllerVisitor);
	
	void changeState();
	
	void askOption();
	
}
