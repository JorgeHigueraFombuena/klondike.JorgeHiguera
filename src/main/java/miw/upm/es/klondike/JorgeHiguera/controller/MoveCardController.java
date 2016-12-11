package miw.upm.es.klondike.JorgeHiguera.controller;

import java.util.List;

import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.PlaceOfCard;

public interface MoveCardController extends OperationController, 
PresenterController
{

	void accept(PlaceCardControllerVisitor colocateControllerVisitor);

	Error movedPermited(List<Card> toPlaceCards, List<Card> placedCards, PlaceOfCard targerPlace);
	
	boolean gameFinished();
	
	void finishTheGame();
}
