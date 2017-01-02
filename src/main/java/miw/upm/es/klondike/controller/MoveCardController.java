package miw.upm.es.klondike.controller;

public interface MoveCardController extends OperationController, PresenterController {

	void accept(MoveCardControllerVisitor colocateControllerVisitor);

	boolean gameFinished();

	void finishTheGame();

	void askOption();
}
