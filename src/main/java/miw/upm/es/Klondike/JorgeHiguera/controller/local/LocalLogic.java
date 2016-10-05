package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.Logic;
import miw.upm.es.klondike.JorgeHiguera.controller.ColocateControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public class LocalLogic implements Logic {
	
	private Game game;
	
	private LocalStartController startController;
	
	private LocalBuilderController builderController;
	
	private LocalColocateController colocateController;

	public LocalLogic(){
		game = new Game();
		builderController = new LocalBuilderController(game);
		startController = new LocalStartController(game, builderController);
		//colocateController = new LocalColocateController(game);
	}
	
	public OperationController getOperationController() {
		switch (game.getState()) {
		case INITIAL:
			return startController;
		case IN_GAME:
			return null;
		case FINISHED:
			return null;
		default:
			return null;
		}
	}

}
