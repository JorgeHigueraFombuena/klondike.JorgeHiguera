package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.model.State;
import miw.upm.es.klondike.JorgeHiguera.controller.Error;

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
		operationalControllerVisitor.visit(this);
	}

	@Override
	public void askFor(int option) {
		this.changeAskOption(option);
	}

	@Override
	public Error isValidOptionSelected(int option) {
		Options op = Options.values()[option];
		Error error = null;
		switch (op) {
		case FROM_DECK_TO_DISCARD:
			return super.validateEmptyDeck() == Error.DECK_EMPTY ? 
					Error.DECK_EMPTY : null;
		case FROM_DISCARD_TO_DECK:
			error = super.validateEmptyDiscard();
			if(error == Error.DISCARD_EMPTY){
				return error;
			}
			return super.validateEmptyDeck() == Error.DECK_NO_EMPTY ?
					Error.DECK_NO_EMPTY : null;
		case FROM_DISCARD_TO_STRIGHT:
			error = super.validateEmptyDiscard();
			if(error == Error.DISCARD_EMPTY){
				return error;
			}
			return null;
		default:
			break;
		}
		return null;
	}

}
