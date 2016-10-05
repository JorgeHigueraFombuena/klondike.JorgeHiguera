package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.ColocateController;
import miw.upm.es.klondike.JorgeHiguera.controller.ColocateControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalColocateController extends LocalOperationController 
implements ColocateController {

	public LocalColocateController(Game game) {
		super(game);
	}

}
