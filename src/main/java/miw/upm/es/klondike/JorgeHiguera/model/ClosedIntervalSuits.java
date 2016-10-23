package miw.upm.es.klondike.JorgeHiguera.model;

public class ClosedIntervalSuits {
	
	public boolean includes(String value){
		return Suit.valueOf(value) != null;
	}
	
}
