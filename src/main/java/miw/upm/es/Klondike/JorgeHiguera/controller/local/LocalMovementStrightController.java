package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementStrightController;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalMovementStrightController extends LocalPlaceCardController implements MovementStrightController {

	public LocalMovementStrightController(Game game) {
		super(game);
	}

	@Override
	public int getOriginStright() {
		return 0;
	}

	@Override
	public int getTargetStright() {
		return 0;
	}

	@Override
	public void accept(MovementControllerVisitor movementControllerVisitor) {
		movementControllerVisitor.visit(this);
	}

}
