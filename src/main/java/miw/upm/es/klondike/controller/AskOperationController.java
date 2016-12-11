package miw.upm.es.klondike.controller;

public interface AskOperationController extends OperationController {

	void accept(AskOperationControllerVisitor askOperationControllerVisitor);

	void askFor(int option);

}
