package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Card;

public interface PlaceCardController extends OperationController, 
	PresenterController
{

	void accept(PlaceCardControllerVisitor colocateControllerVisitor);
	
	void move();

	Error movedPermited(Card toPlace, Card placed);
	
}
