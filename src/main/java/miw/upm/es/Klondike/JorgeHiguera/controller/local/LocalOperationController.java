package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalOperationController extends LocalController 
implements OperationController {

	public LocalOperationController(Game game) {
		super(game);
	}

	
	public abstract void accept(OperationControllerVisitor operationalControllerVisitor);

}
