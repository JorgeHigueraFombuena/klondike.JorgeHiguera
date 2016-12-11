package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.OperationController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.model.Game;

public abstract class LocalOperationController extends LocalController implements OperationController {

	public LocalOperationController(Game game) {
		super(game);
	}

	@Override
	public abstract void accept(OperationControllerVisitor operationalControllerVisitor);

}
