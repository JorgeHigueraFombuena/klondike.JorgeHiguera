package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.model.Game;

public class TestLocalFaceupInStrightController {

	private LocalFaceUpInStrightController localFaceUpInStrightController;
	private Game game;

	@Before
	public void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localFaceUpInStrightController = new LocalFaceUpInStrightController(game);
		localBuilderController.build();
	}

	@Test
	public void testOk() {
		try {
			game.getStrights().get(1).get(0).setFaceDown(true);
			Error error = localFaceUpInStrightController.move(1);
			assertTrue(error == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testError() {
		try {
			Error error = localFaceUpInStrightController.move(1);
			assertTrue(error != null);
		} catch (Exception e) {
			assert (false);
		}
	}

}
