package miw.upm.es.klondike.controller.local;

import org.junit.Before;
import org.junit.Test;

import miw.upm.es.klondike.model.Game;

public class TestLocalBuilderController {

	private LocalBuilderController localBuilderController;

	@Before
	public void setUp() {
		Game game = new Game();
		localBuilderController = new LocalBuilderController(game);
	}

	@Test
	public void testOk() {
		try {
			localBuilderController.build();
			assert (true);
		} catch (Exception e) {
			assert (false);
		}
	}

}
