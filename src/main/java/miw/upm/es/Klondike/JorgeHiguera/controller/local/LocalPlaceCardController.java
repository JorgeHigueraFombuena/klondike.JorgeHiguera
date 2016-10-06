package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalPlaceCardController extends LocalOperationController 
implements PlaceCardController {

	public LocalPlaceCardController(Game game) {
		super(game);
	}

}
