package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.BuilderController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.controller.StartController;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.State;

public class LocalStartController extends LocalOperationController implements StartController {

	private BuilderController builder;
	
	public LocalStartController(Game game, BuilderController builder) {
		super(game);
		assert builder != null;
		this.builder = builder;
	}

	@Override
	public void start() {
		assert this.getState() == State.INITIAL;
		builder.build();
		this.setState(State.ASK_OPERATION);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		assert operationalControllerVisitor != null;
		operationalControllerVisitor.visit(this);
	}

}
