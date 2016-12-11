package miw.upm.es.klondike.view;

import miw.upm.es.klondike.controller.AskOperationController;
import miw.upm.es.klondike.controller.AskOperationControllerVisitor;
import miw.upm.es.klondike.model.Options;
import miw.upm.es.klondike.utils.IO;
import miw.upm.es.klondike.utils.LimitedIntDialog;

public class AskOptionView implements AskOperationControllerVisitor {

	IO io = new IO();

	@Override
	public void visit(AskOperationController askOperationController) {
		int option = -1;
		option = new LimitedIntDialog("Opción?", 1, Options.values().length).read() - 1;
		askOperationController.askFor(option);
	}

	public void interact(AskOperationController askOperationController) {
		for (Options option : Options.values()) {
			io.writeln(option.toString());
		}
		askOperationController.accept(this);
	}

}
