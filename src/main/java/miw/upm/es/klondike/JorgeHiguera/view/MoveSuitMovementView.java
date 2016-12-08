package miw.upm.es.klondike.JorgeHiguera.view;


import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public class MoveSuitMovementView {

	public Suit getOriginSuit() {
		PositionView positionView = new PositionView(
				"Desde qué palo?", "Palo? [oros, bastos, espadas, copas]");
		positionView.readSuit();
		return positionView.getSuit();
	}
	
}
