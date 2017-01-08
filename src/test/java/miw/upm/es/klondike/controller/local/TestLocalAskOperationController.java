package miw.upm.es.klondike.controller.local;

import org.junit.Before;
import org.junit.Test;

import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.Options;

public class TestLocalAskOperationController {

	private LocalAskOperationController localAskOperationController;

	@Before
	public void setUp() {
		Game game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localAskOperationController = new LocalAskOperationController(game);
	}

	@Test
	public void changeEveryOption() {
		try {
			for (int i = 0; i < Options.values().length; i++) {
				localAskOperationController.askFor(i);
			}
			assert (true);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void errorOption() {
		try {
			int option = Options.values().length + 10;
			localAskOperationController.askFor(option);
			assert (false);
		} catch (Exception e) {
			assert (true);
		}
	}

}
