package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.MoveCardControllerVisitor;
import miw.upm.es.klondike.model.Game;

public class LocalMoveFromDeckToDiscardController extends LocalMoveCardContoller
		implements MoveFromDeckToDiscardController {

	public LocalMoveFromDeckToDiscardController(Game game) {
		super(game);
	}

	@Override
	public void accept(MoveCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public Error move() {
		Error error = movedPermited();
		if (error == null) {
			super.moveFromDeckToDiscard();
		}
		return error;
	}

	@Override
	public Error movedPermited() {
		return super.validateEmptyDeck() == Error.DECK_EMPTY ? Error.DECK_EMPTY : null;
	}

}
