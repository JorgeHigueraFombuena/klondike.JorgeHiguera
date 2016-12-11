package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.Logic;
import miw.upm.es.klondike.controller.OperationController;
import miw.upm.es.klondike.model.Game;

public class LocalLogic implements Logic {

	private Game game;

	private LocalStartController startController;

	private LocalBuilderController builderController;

	public LocalLogic() {
		game = new Game();
		builderController = new LocalBuilderController(game);
		startController = new LocalStartController(game, builderController);
	}

	@Override
	public OperationController getOperationController() {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case ASK_OPERATION:
			return builderController.getAskOperationController();
		case IN_GAME:
			return builderController.getOperationController(game.getOptionSelected());
		case FINISHED:
			return null;
		default:
			return null;
		}
	}

}
