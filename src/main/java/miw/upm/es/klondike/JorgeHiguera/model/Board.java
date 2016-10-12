package miw.upm.es.klondike.JorgeHiguera.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
	
	private Map<Integer, List<Card>> strights;
	
	private List<Card> discard;
	
	private List<Card> deck;
	
	private Map<Suit, List<Card>> suits;
	
	private final static int NUM_CARDS_PER_DRAW = 3;	
	
	public final static int NUM_STRIGHTS = 7;
	
	public final static int NUM_CARDS_PER_SUIT = 12;
	
	public Board(){
		suits = new HashMap<Suit, List<Card>>();
		for(int i = 0; i < getSuit().length; i++){
			suits.put(Suit.values()[i], new ArrayList<Card>());
		}
		strights = new HashMap<Integer, List<Card>>();
		for(int i = 0; i < NUM_STRIGHTS; i++){
			strights.put(i, new ArrayList<Card>());
		}
		discard = new ArrayList<Card>();
		deck = new ArrayList<Card>();
	}
	
	public Suit[] getSuit(){
		return Suit.values();
	}

	public void moveFromDeckToDiscard() {
		List<Card> tempList = new ArrayList<Card>();
		for(int i = 0; i < deck.size() 
				&& i < NUM_CARDS_PER_DRAW; i++){
			deck.get(i).setFaceDown(false);
			tempList.add(deck.get(i));
		}
		deck.removeAll(tempList);
		discard.addAll(tempList);
	}
	
	public void moveFromDiscardToDeck(){
		for(int i = discard.size() - 1; i >= 0; i--){
			discard.get(i).setFaceDown(true);
			deck.add(discard.get(i));
		}
		discard.clear();
	}

	public boolean isEmptyDeck() {
		return deck.isEmpty();
	}
	

	public List<Card> getDeck(){
		return deck;
	}
	
	public List<Card> getDiscard(){
		return discard;
	}
	
	public Map<Integer, List<Card>> getStrights(){
		return strights;
	}
	
	public Map<Suit, List<Card>> getSuits(){
		return suits;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public void setStrights(Map<Integer, List<Card>> strights) {
		this.strights = strights;
	}

	public boolean isEmptyDiscard() {
		return discard.isEmpty();
	}
}
