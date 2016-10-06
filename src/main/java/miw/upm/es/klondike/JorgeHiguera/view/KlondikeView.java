package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.View;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.StartController;

public class KlondikeView implements View{

	private StartView startView;
	
	private GameView gameView;
	
	private AskOptionView askOptionView;
	
	public KlondikeView(){
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
		startView.interact(startController);
	}

	@Override
	public void visit(PlaceCardController colocateController) {
		gameView.interact(colocateController);
	}

	@Override
	public void visit(AskOperationController AskOperationController) {
		askOptionView.interact(AskOperationController);
	}

}
