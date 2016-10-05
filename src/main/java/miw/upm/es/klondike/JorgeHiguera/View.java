package miw.upm.es.klondike.JorgeHiguera;

import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;

public interface View extends OperationControllerVisitor{
	
	public void interact(OperationController operationalController);

}
