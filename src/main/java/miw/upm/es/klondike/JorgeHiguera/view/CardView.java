package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;

public class CardView {

	private static final char[] SUITS = {'c', 'o', 'b', 'e'};

	private static final char[] SYMBOLS_CARDS = 
		{
				'A','2','3','4','5',
				'6','7','8','9','J','Q','K'
		};
	
	private static final char UNTAP_CARD = 'X';

	private Card card;

	private IO io;
	
	private boolean stright;
	
	private boolean last;
	
	public CardView(Card card, boolean stright, boolean last){
		this(card);
		assert stright;
		this.stright = stright;
		this.last = last;
	}

	public CardView(Card card){
		this();
		this.card = card;
	}
	
	public CardView(){
		io = new IO();
	}

	void write(){
		if(!card.isFaceDown()){
			writeCard(symbolToChart(), suitToChar());
		}
		else if((stright && last && card.isFaceDown()) ||
				(!stright && card.isFaceDown())){
			writeFaceDown();
		}
		else if (stright && !last){
			writeMiddleStright();
		}
	}

	private char suitToChar(){
		return SUITS[card.getSuit().ordinal()];
	}
	
	private char symbolToChart(){
		return SYMBOLS_CARDS[card.getNumber()-1];
	}
	
	private void writeMiddleStright() {
		io.write("[");
	}
	
	public void writeFaceDown(){
		writeCard(UNTAP_CARD,UNTAP_CARD);
	}

	private void writeCard(char numberCard, char suit){
		io.write("[" + numberCard + "," + suit + "]");
	}
	
}
