package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import miw.upm.es.klondike.model.Board;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;
import miw.upm.es.klondike.model.State;
import miw.upm.es.klondike.model.Suit;

public class TestLocalMoveCardController {

	private Game game;
	private LocalMoveFromDeckToDiscardController localMoveFromDeckToDiscardController;

	@Before
	public void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromDeckToDiscardController = new LocalMoveFromDeckToDiscardController(game);
	}

	@Test
	public void testGameFinishedTrue() {
		try {
			for (Entry<Suit, List<Card>> suit : game.getSuits().entrySet()) {
				for (int j = 0; j < Board.NUM_CARDS_PER_SUIT; j++) {
					suit.getValue().add(new Card(Suit.BASTOS, 1, PlaceOfCard.SUIT));
				}
			}
			assertTrue(localMoveFromDeckToDiscardController.gameFinished());
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testGameFinishedFalse() {
		try {
			assertFalse(localMoveFromDeckToDiscardController.gameFinished());
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testFinishTheGame() {
		try {
			localMoveFromDeckToDiscardController.finishTheGame();
			assertTrue(game.getState() == State.FINISHED);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testAskOption() {
		try {
			localMoveFromDeckToDiscardController.changeAskOption(3);
			localMoveFromDeckToDiscardController.askOption();
			assertTrue(game.getState() == State.ASK_OPERATION);
		} catch (Exception e) {
			assert (false);
		}
	}
}
