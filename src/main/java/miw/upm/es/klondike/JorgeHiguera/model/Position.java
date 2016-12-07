package miw.upm.es.klondike.JorgeHiguera.model;

public class Position {
	
	private int pos;
	
	private Suit suit;
	
	private Card card;
	
	public static final int NUM_STRIGHTS = 7;
	
	public static final int NUM_CARDS_PER_SUIT = 12;
	
	public Position(int position, Card card){
		assert position > 0;
		assert card != null;
		this.pos = position;
		this.card = card;
	}
	
	public Position(Suit suit, Card card){
		assert suit != null;
		assert card != null;
		this.suit = suit;
		this.card = card;
	}
	
	public int getPosition(){
		return pos;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public Card getCard(){
		return card;
	}
}
