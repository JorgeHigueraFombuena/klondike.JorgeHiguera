package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.controller.StartController;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.utils.LimitedIntDialog;

public class AskOptionView implements AskOperationControllerVisitor {

	IO io = new IO();

	@Override
	public void visit(AskOperationController askOperationController) {
		int option = -1;
		Error error = null;
		option = new LimitedIntDialog("Opción?", 1, Options.values().length).read() - 1;
		error = askOperationController.isValidOptionSelected(option);
		if(error != null){
			io.writeError(error);
		}

		askOperationController.askFor(option);
	}

	public void interact(AskOperationController askOperationController) {
		for(Options option : Options.values()){
			io.writeln(option.toString());
		}
		askOperationController.accept(this);
	}

}
