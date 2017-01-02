package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.MoveCardControllerVisitor;
import miw.upm.es.klondike.model.Game;

public class LocalMoveFromDiscardToDeckController extends LocalMoveCardContoller
		implements MoveFromDiscardToDeckController {

	public LocalMoveFromDiscardToDeckController(Game game) {
		super(game);
	}

	@Override
	public void accept(MoveCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move() {
		Error error = movedPermited();
		if (error != null) {
			super.moveFromDiscardToDeck();
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public Error movedPermited() {
		Error error = super.validateEmptyDiscard();
		if (error == Error.DISCARD_EMPTY) {
			return error;
		}
		return super.validateEmptyDeck() == Error.DECK_NO_EMPTY ? Error.DECK_NO_EMPTY : null;
	}

}
