package miw.upm.es.klondike.JorgeHiguera.controller;

public interface PlaceCardController extends OperationController, 
	PresenterController
{

	void accept(PlaceCardControllerVisitor colocateControllerVisitor);
	
	void move();
	
}
