package miw.upm.es.klondike.view;

import miw.upm.es.klondike.model.Board;

public class MoveStrightMovementView {

	public int getTargetStright(){
		PositionView positionView = new PositionView(
				"A qué escalera?", "Escalera?", Board.NUM_STRIGHTS);
		positionView.readInt();
		return positionView.getPosition();
	}

	public int getOriginStright() {
		PositionView positionView = new PositionView(
				"Desde qué escalera?", "Escalera?", Board.NUM_STRIGHTS);
		positionView.readInt();
		return positionView.getPosition();
	}

}
