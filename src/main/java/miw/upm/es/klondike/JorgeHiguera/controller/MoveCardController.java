package miw.upm.es.klondike.JorgeHiguera.controller;

import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public interface MoveCardController extends OperationController, 
PresenterController
{

	void accept(PlaceCardControllerVisitor colocateControllerVisitor);

	Error movedPermited(Card toPlace, Card placed, PlaceOfCard targerPlace);

	Error isStrightCorrect(int stright, Card card);

}
