package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.ColocateControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public abstract class LocalMoveFromDeckToDiscardController extends LocalColocateController
		implements MoveFromDeckToDiscardController {
	
	public LocalMoveFromDeckToDiscardController(Game game) {
		super(game);
	}

	@Override
	public void accept(ColocateControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public void move() {
		assert super.validateEmptyDeck() == null;
		super.moveFromDeckToDiscard();
	}

}
