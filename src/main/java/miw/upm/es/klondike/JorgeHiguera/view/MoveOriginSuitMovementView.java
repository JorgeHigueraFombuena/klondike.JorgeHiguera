package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public abstract class MoveOriginSuitMovementView {

	private int suit;
	
	
	public void visit(MovementSuitController movementSuitController) {
		PositionView positionView = new PositionView(
				"De qué palo?", "Palo?", Suit.values().length);
		positionView.read();
		suit = positionView.getPosition();
	}

}
