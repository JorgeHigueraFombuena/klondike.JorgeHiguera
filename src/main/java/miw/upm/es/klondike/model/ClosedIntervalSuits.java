package miw.upm.es.klondike.model;

public class ClosedIntervalSuits {
	
	public boolean includes(String value){
		return Suit.valueOf(value) != null;
	}
	
}
