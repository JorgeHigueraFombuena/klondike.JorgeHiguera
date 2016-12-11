package miw.upm.es.klondike.view;


import miw.upm.es.klondike.model.Suit;

public class MoveSuitMovementView {

	public Suit getOriginSuit() {
		PositionView positionView = new PositionView(
				"Desde qué palo?", "Palo? [oros, bastos, espadas, copas]");
		positionView.readSuit();
		return positionView.getSuit();
	}
	
}
