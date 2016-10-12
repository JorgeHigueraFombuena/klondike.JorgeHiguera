package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.model.State;

public abstract class LocalOperationController extends LocalController 
implements OperationController {

	public LocalOperationController(Game game) {
		super(game);
	}

	public abstract void accept(OperationControllerVisitor operationalControllerVisitor);

	@Override
	public void changeState() {
		if(this.getSelectedOption() != Options.EXIT){
			this.setState(State.IN_GAME);
		}
		else{
			this.setState(State.FINISHED);
		}
	}
	
	@Override
	public void askOption(){
		this.setState(State.ASK_OPERATION);
	}
}
