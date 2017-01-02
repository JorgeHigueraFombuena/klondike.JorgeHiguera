package miw.upm.es.klondike.controller;

import java.util.List;

import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.PlaceOfCard;

public interface MoveCardController extends OperationController, PresenterController {

	void accept(PlaceCardControllerVisitor colocateControllerVisitor);

	boolean gameFinished();

	void finishTheGame();

	void askOption();
}
