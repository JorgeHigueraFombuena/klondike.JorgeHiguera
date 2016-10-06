package miw.upm.es.klondike.JorgeHiguera.controller;

public interface AskOperationController extends OperationController {

	void accept(AskOperationControllerVisitor askOperationControllerVisitor);

	void askFor(int option);

	void changeState();
}
