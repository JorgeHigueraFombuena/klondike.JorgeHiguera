package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.model.Game;

public class LocalMoveFromDiscardToDeckController extends LocalMoveCardContoller 
implements MoveFromDiscardToDeckController{

	public LocalMoveFromDiscardToDeckController(Game game) {
		super(game);
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move() {
		super.moveFromDiscardToDeck();
		return null;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
