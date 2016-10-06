package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementController;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalMovementController extends LocalController
		implements MovementController {

	public LocalMovementController(Game game) {
		super(game);
	}


}
