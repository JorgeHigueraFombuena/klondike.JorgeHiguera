package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.AskOperationController;
import miw.upm.es.klondike.controller.AskOperationControllerVisitor;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.model.Game;

public class LocalAskOperationController extends LocalOperationController implements AskOperationController {

	public LocalAskOperationController(Game game) {
		super(game);
	}

	@Override
	public void accept(AskOperationControllerVisitor askOperationControllerVisitor) {
		askOperationControllerVisitor.visit(this);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

	@Override
	public void askFor(int option) {
		this.changeAskOption(option);
		super.changeState();
	}
}
