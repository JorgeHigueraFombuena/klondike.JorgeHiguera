package miw.upm.es.klondike.JorgeHiguera.model;

public class Card {
	
	private Suit suit;
	
	private int number;
	
	private boolean faceDown;
	
	public Card(Suit suit, int number){
		assert suit != null;
		assert number > 0;
		assert number <= 12;
		this.suit = suit;
		this.number = number;
	}
	
	public Card(Suit suit, int number, boolean faceDown){
		this(suit, number);
		this.faceDown = faceDown;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean isFaceDown(){
		return faceDown;
	}

	public void setFaceDown(boolean faceDown){
		this.faceDown = faceDown;
	}

	@Override
	public boolean equals(Object obj) {
		return 	obj instanceof Card &&
				suit == ((Card)obj).getSuit() &&
				number == ((Card)obj).getNumber() &&
				faceDown == ((Card)obj).isFaceDown();
	}
	
	
}
