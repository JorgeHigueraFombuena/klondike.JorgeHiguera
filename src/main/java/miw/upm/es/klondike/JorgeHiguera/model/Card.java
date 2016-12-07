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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (faceDown ? 1231 : 1237);
		result = prime * result + number;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}
	
	public boolean isKing() {
		return number == Board.KING_NUMBER;
	}

	public boolean isAce() {
		return number == Board.ACE_NUMBER;
	}
	
	
}
