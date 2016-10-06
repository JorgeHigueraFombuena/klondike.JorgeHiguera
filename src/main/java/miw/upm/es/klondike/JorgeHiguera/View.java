package miw.upm.es.klondike.JorgeHiguera;

import miw.upm.es.klondike.JorgeHiguera.controller.OperationController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;

public interface View extends OperationControllerVisitor{
	
	public void interact(OperationController operationalController);


}
