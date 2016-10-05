package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementSuitController;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalMovementSuitController extends LocalMovementController implements MovementSuitController {

	public LocalMovementSuitController(Game game) {
		super(game);
	}

	@Override
	public int getOriginSuit() {
		return 0;
	}

	@Override
	public void accept(MovementControllerVisitor movementControllerVisitor) {
		movementControllerVisitor.visit(this);
	}

}
