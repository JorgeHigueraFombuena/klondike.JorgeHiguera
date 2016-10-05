package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.MovementController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.MovementSuitController;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public abstract class MoveOriginSuitMovementView extends MovementView {

	private int suit;

	public MoveOriginSuitMovementView(MovementController movementController) {
		super(movementController);
	}

	int getPosition(){
		this.getMovementController().accept(this);
		return suit;
	}
	
	@Override
	public void visit(MovementSuitController movementSuitController) {
		PositionView positionView = new PositionView(
				"De qué palo?", "Palo?", Suit.values().length);
		positionView.read();
		suit = positionView.getPosition();
	}

}
