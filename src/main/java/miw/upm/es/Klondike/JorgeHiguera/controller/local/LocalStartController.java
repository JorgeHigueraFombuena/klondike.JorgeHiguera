package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.BuilderController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.StartController;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.State;
import miw.upm.es.klondike.JorgeHiguera.view.BoardView;

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
		this.setState(State.IN_GAME);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
