package miw.upm.es.klondike.view;

import miw.upm.es.klondike.View;
import miw.upm.es.klondike.controller.AskOperationController;
import miw.upm.es.klondike.controller.MoveCardController;
import miw.upm.es.klondike.controller.OperationController;
import miw.upm.es.klondike.controller.StartController;

public class KlondikeView implements View {

	private StartView startView;

	private GameView gameView;

	private AskOptionView askOptionView;

	public KlondikeView() {
		startView = new StartView();
		gameView = new GameView();
		askOptionView = new AskOptionView();
	}

	@Override
	public void interact(OperationController operationalController) {
		assert operationalController != null;
		operationalController.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		assert startController != null;
		startView.interact(startController);
	}

	@Override
	public void visit(MoveCardController moveCardController) {
		assert moveCardController != null;
		gameView.interact(moveCardController);
	}

	@Override
	public void visit(AskOperationController askOperationController) {
		assert askOperationController != null;
		askOptionView.interact(askOperationController);
	}

}
