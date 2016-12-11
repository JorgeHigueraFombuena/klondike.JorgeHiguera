package miw.upm.es.klondike;

import miw.upm.es.klondike.controller.OperationController;
import miw.upm.es.klondike.controller.OperationControllerVisitor;

public interface View extends OperationControllerVisitor{
	
	public void interact(OperationController operationalController);


}
