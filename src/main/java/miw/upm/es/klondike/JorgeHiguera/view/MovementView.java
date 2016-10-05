package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementControllerVisitor;

public abstract class MovementView implements MovementControllerVisitor {

	private MovementController movementController;
	
	public MovementView(MovementController movementController){
		assert movementController != null;
		this.movementController = movementController;
	}
	
	abstract int getPosition();
	
	protected MovementController getMovementController(){
		return movementController;
	}

}
