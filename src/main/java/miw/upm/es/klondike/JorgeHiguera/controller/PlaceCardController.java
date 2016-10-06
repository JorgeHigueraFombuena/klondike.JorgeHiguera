package miw.upm.es.klondike.JorgeHiguera.controller;

public interface ColocateController extends OperationController, 
	PresenterController
{

	void accept(ColocateControllerVisitor colocateControllerVisitor);
	
	void move();
	
}
