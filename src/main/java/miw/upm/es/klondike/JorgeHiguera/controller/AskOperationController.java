package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Options;

public interface AskOperationController extends OperationController {

	void accept(AskOperationControllerVisitor askOperationControllerVisitor);

	void askFor(int option);
	
	Error isValidOptionSelected(int option);

}
