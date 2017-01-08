package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.model.Game;

public class TestLocalMoveFromDeckToDiscardController {

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
	public void testGoodMove() {
		try {
			assertTrue(localMoveFromDeckToDiscardController.move() == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			game.getDeck().clear();
			assertTrue(localMoveFromDeckToDiscardController.move() == Error.DECK_EMPTY);
		} catch (Exception e) {
			assert (false);
		}
	}
}
