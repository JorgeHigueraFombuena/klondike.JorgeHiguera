package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.model.Game;

public class TestLocalMoveFromDiscardToDeckController {

	private Game game;
	private LocalMoveFromDiscardToDeckController localMoveFromDiscardToDeckController;

	@Before
	public void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromDiscardToDeckController = new LocalMoveFromDiscardToDeckController(game);
	}

	@Test
	public void testGoodMove() {
		try {
			while (!game.isEmptyDeck()) {
				game.moveFromDeckToDiscard();
			}
			assertTrue(localMoveFromDiscardToDeckController.move() == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			assertTrue(localMoveFromDiscardToDeckController.move() == Error.DISCARD_EMPTY);
		} catch (Exception e) {
			assert (false);
		}
	}
}
