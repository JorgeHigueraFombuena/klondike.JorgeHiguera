package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.ColocateController;
import miw.upm.es.klondike.JorgeHiguera.controller.ColocateControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToDeckController;

public class GameView implements ColocateControllerVisitor{

	void interact(ColocateController colocateController){
		colocateController.accept(this);
	}

	@Override
	public void visit(MoveFromDeckToDiscardController moveFromDeckToDiscardController) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MoveFromDiscardToDeckController moveFromDiscardToDeckController) {
		// TODO Auto-generated method stub
		
	}
	
}
