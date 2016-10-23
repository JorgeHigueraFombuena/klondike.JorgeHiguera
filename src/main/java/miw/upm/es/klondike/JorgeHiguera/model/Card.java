package miw.upm.es.klondike.JorgeHiguera.model;

public class Card {
	
	private Suit suit;
	
	private int number;
	
	private boolean faceDown;
	
	private PlaceOfCard place;
	
	public Card(Suit suit, int number, PlaceOfCard place){
		assert suit != null;
		assert number > 0;
		assert number <= 12;
		assert place != null;
		this.suit = suit;
		this.number = number;
		this.place = place;
	}
	
	public Card(Suit suit, int number, PlaceOfCard place, boolean faceDown){
		this(suit, number, place);
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
	
	public PlaceOfCard getPlaceOfCard(){
		return place;
	}
	
	public void setPlaceOfCard(PlaceOfCard place){
		this.place = place;
	}

	@Override
	public boolean equals(Object obj) {
		return 	obj instanceof Card &&
				suit == ((Card)obj).getSuit() &&
				number == ((Card)obj).getNumber() &&
				faceDown == ((Card)obj).isFaceDown();
	}

	public boolean isKing() {
		return number == Board.NUM_CARDS_PER_SUIT;
	}
	
	
}
