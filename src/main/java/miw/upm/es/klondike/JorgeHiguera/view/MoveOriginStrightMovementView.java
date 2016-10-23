package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.model.Board;

public class MoveOriginStrightMovementView {

	public int getStright(){
		PositionView positionView = new PositionView(
				"A qué escalera?", "Escalera?", Board.NUM_STRIGHTS);
		positionView.read();
		return positionView.getPosition();
	}

}
