package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public class LocalMoveFromDiscardToDeckController extends LocalPlaceCardController 
implements MoveFromDiscardToDeckController{

	public LocalMoveFromDiscardToDeckController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
