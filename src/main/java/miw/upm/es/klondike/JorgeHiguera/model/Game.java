package miw.upm.es.klondike.JorgeHiguera.model;

import java.util.List;
import java.util.Map;

public class Game {
	
	private State state;
	
	private Board board;
	
	private Options optionSelected;

	public Game(){
		state = State.INITIAL;
		board = new Board();
	}
	
	public void moveFromDeckToDiscard() {
		board.moveFromDeckToDiscard();
	}

	public boolean isEmptyDeck() {
		return board.isEmptyDeck();
	}
	
	public List<Card> getDeck(){
		return board.getDeck();
	}
	
	public List<Card> getDiscard(){
		return board.getDiscard();
	}
	
	public Map<Integer, List<Card>> getStrights(){
		return board.getStrights();
	}
	
	public Map<Suit, List<Card>> getSuits(){
		return board.getSuits();
	}
	
	public State getState(){
		return state;
	}
	
	public Options getOptionSelected(){
		return optionSelected;
	}

	public void setDeck(List<Card> deck) {
		board.setDeck(deck);
	}

	public void setStrights(Map<Integer, List<Card>> strights) {
		board.setStrights(strights);
	}

	public void setState(State state) {
		this.state = state;;
	}

	public void changeAskOption(int option) {
		optionSelected = Options.values()[option];
	}

	public boolean isEmptyDiscard() {
		return board.isEmptyDiscard();
	}

	public void moveFromDiscardToDeck() {
		board.moveFromDiscardToDeck();
	}

	public int getNumStrights() {
		return board.getNumStrights();
	}

	public Card getFirstCardFromStright(int stright) {
		return board.getFirstCardFromStright(stright);
	}

	public Card getFirstCardFromDiscard() {
		return board.getFirstCardFromDiscard();
	}

	public void moveFromDiscardToStright(Card toPlace, int stright) {
		board.moveFromDiscardToStright(toPlace, stright);
	}

	public void moveFromStrightToStright(int originStright, int targetStright) {
		board.moveFromStrightToStright(originStright, targetStright);
	}

	public Card getFirstCardFromSuit(Card toPlace) {
		return board.getFirstCardFromSuit(toPlace);
	}

	public void moveFromDiscardToSuit(Card toPlace) {
		board.moveFromDiscardToSuit(toPlace);
	}

}
