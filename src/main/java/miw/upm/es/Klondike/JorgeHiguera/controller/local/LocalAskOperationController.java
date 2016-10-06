package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.model.State;

public class LocalAskOperationController extends LocalOperationController 
implements AskOperationController {

	
	public LocalAskOperationController(Game game) {
		super(game);
	}

	@Override
	public void accept(AskOperationControllerVisitor askOperationControllerVisitor) {
		askOperationControllerVisitor.visit(this);
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		// TODO Auto-generated method stub
		operationalControllerVisitor.visit(this);
	}

	@Override
	public void askFor(int option) {
		this.changeAskOption(option);
	}

	@Override
	public void changeState() {
		if(this.getSelectedOption() != Options.EXIT){
			this.setState(State.IN_GAME);
		}
		else{
			this.setState(State.FINISHED);
		}
	}

}
