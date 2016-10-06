package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.AskOperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.controller.StartController;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.utils.LimitedIntDialog;

public class AskOptionView implements AskOperationControllerVisitor {

	IO io = new IO();
	
	@Override
	public void visit(AskOperationController askOperationController) {
		int option = new LimitedIntDialog("Opción?", 1, Options.values().length).read();
		askOperationController.askFor(option);
		askOperationController.changeState();
	}

	public void interact(AskOperationController askOperationController) {
		for(Options option : Options.values()){
			io.writeln(option.toString());
		}
		askOperationController.accept(this);
	}

}
