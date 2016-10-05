package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementSuitController;
import miw.upm.es.klondike.JorgeHiguera.model.Board;

public abstract class MoveTargetStrightMovementView extends MoveStrightMovementView {

	private int stright;
	
	public MoveTargetStrightMovementView(MovementController movementController) {
		super(movementController);
	}
	
	@Override
	public void visit(MovementStrightController movementStrightController) {
		PositionView positionView = new PositionView(
				"A qué escalera?", "Escalera?", Board.NUM_STRIGHTS);
		positionView.read();
		stright = positionView.getPosition();
	}
}
