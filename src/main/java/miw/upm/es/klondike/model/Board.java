package miw.upm.es.klondike.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Board {

	private Map<Integer, List<Card>> strights;

	private List<Card> discard;

	private List<Card> deck;

	private Map<Suit, List<Card>> suits;

	private final static int NUM_CARDS_PER_DRAW = 3;	

	public final static int NUM_STRIGHTS = 7;

	public final static int NUM_CARDS_PER_SUIT = 12;

	public final static int ACE_NUMBER = 1;

	public final static int KING_NUMBER = 12;

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
			deck.get(i).setPlaceOfCard(PlaceOfCard.DISCARD);
			tempList.add(deck.get(i));
		}
		deck.removeAll(tempList);
		discard.addAll(tempList);
	}

	public void moveFromDiscardToDeck(){
		for(int i = 0; i < discard.size(); i++){
			discard.get(i).setFaceDown(true);
			discard.get(i).setPlaceOfCard(PlaceOfCard.DECK);;
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

	public int getNumStrights() {
		return NUM_STRIGHTS;
	}

	public List<Card> getFaceUpCardsOfStright(int stright) {
		if(strights.get(stright).isEmpty()){
			return new ArrayList<Card>();
		}
		else {
			List<Card> cards = new ArrayList<Card>();
			List<Card> strightCards = strights.get(stright);
			for(Card card : strightCards){
				if(!card.isFaceDown()){
					cards.add(card);
				}
			}
			return cards;
		}
	}

	public Card getFirstCardFromDiscard() {
		if(discard.isEmpty()){
			return null;
		}
		else {
			return discard.get(discard.size()-1);
		}
	}

	public void moveFromDiscardToStright(Card toPlace, int stright) {
		discard.remove(toPlace);
		toPlace.setPlaceOfCard(PlaceOfCard.STRIGHT);
		strights.get(stright).add(toPlace);
	}

	public void moveFromStrightToStright(int originStright, int targetStright) {
		List<Card> originStrightCards = getFaceUpCardsOfStright(originStright);
		List<Card> targetStrightCards = getFaceUpCardsOfStright(targetStright);
		List<Card> toPlaceCards = null;
		if(targetStrightCards.isEmpty()){
			toPlaceCards = this.getCardsMovedPermited(originStrightCards,
					null);
		}
		else {
			toPlaceCards = this.getCardsMovedPermited(originStrightCards,
					targetStrightCards.get(targetStrightCards.size() - 1));
		}
		strights.get(originStright).removeAll(toPlaceCards);
		strights.get(targetStright).addAll(toPlaceCards);
	}

	private List<Card> getCardsMovedPermited(List<Card> toPlaceCards, Card placed){
		List<Card> cards = new ArrayList<Card>();
		int i = getFirstCardPermitedToMove(toPlaceCards, placed);
		for(int j = i; j < toPlaceCards.size(); j++){
			cards.add(toPlaceCards.get(j));
		}
		return cards;
	}
	
	private int getFirstCardPermitedToMove(List<Card> toPlaceCards, Card placed){
		int i = 0;
		boolean found = false;
		while(i < toPlaceCards.size() && !found){
			Card toPlace = toPlaceCards.get(i);
			if(placed == null && toPlace.isKing()){
				found = true;
			}
			else if(placed != null && placed.isFaceDown() && toPlace.isKing()){
				found = true;
			}
			else if(placed != null && !toPlace.getSuit().equals(placed.getSuit())
					&& placed.getNumber() - toPlace.getNumber() == 1){
				found = true;
			}
			else{
				i++;
			}
		}
		return i;
	}

	public Card getFirstCardFromSuit(Suit suit) {
		if (suit == null || suits.get(suit).isEmpty()){
			return null;
		}
		else {
			return suits.get(suit).get(suits.get(suit).size()-1);
		}
	}

	public void moveFromDiscardToSuit(Card toPlace) {
		discard.remove(toPlace);
		toPlace.setPlaceOfCard(PlaceOfCard.SUIT);
		suits.get(toPlace.getSuit()).add(toPlace);
	}

	public void moveFromStrightToSuit(int originStright) {
		Card toPlace = strights.get(originStright).get(strights.get(originStright).size() -1);
		strights.get(originStright).remove(toPlace);
		suits.get(toPlace.getSuit()).add(toPlace);
	}

	public void moveFromSuitToStright(Suit originSuit, int targetStright) {
		Card toPlace = suits.get(originSuit).get(suits.get(originSuit).size()-1);
		suits.get(originSuit).remove(suits.get(originSuit).size()-1);
		toPlace.setPlaceOfCard(PlaceOfCard.STRIGHT);
		strights.get(targetStright).add(toPlace);
	}

	public void faceUpCard(int targetStright) {
		strights.get(targetStright).get(strights.get(targetStright).size() - 1).setFaceDown(false);
	}

	public Card getFirstCardOfStright(int stright) {
		if(strights.get(stright).isEmpty()){
			return null;
		}
		else {
			return strights.get(stright).get(strights.get(stright).size() - 1);
		}
	}

	public boolean gameFinished(){
		boolean finished = true;
		for(Entry<Suit, List<Card>> suitWithCards : suits.entrySet()){
			finished = finished && suitWithCards.getValue().size() == NUM_CARDS_PER_SUIT;
		}
		return finished;
	}
}
