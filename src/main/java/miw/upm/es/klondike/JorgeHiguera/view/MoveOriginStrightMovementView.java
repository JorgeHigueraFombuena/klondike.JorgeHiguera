package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementSuitController;
import miw.upm.es.klondike.JorgeHiguera.model.Board;

public abstract class MoveOriginStrightMovementView extends MovementView {

	private int stright;
	
	public MoveOriginStrightMovementView(MovementController movementController){
		super(movementController);
	}

	@Override
	public void visit(MovementStrightController movementStrightController) {
		PositionView positionView = new PositionView(
				"De qué escalera?", "Escalera?", Board.NUM_STRIGHTS);
		positionView.read();
		stright = positionView.getPosition();
	}
	
}
