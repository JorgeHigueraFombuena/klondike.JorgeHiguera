package miw.upm.es.klondike.controller.local;

import java.util.List;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveCardController;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public abstract class LocalMoveCardContoller extends LocalOperationController implements MoveCardController {

	public LocalMoveCardContoller(Game game) {
		super(game);
	}

	

	@Override
	public boolean gameFinished() {
		return super.gameFinished();
	}

	@Override
	public void finishTheGame() {
		super.finishTheGame();
	}

	@Override
	public void askOption() {
		super.askOption();
	}
}
