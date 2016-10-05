package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.View;
import miw.upm.es.klondike.JorgeHiguera.controller.ColocateController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.StartController;

public class KlondikeView implements View{

	private StartView startView;
	
	private GameView gameView;
	
	public KlondikeView(){
		startView = new StartView();
		gameView = new GameView();
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
	public void visit(ColocateController colocateController) {
		gameView.interact(colocateController);
	}



}
