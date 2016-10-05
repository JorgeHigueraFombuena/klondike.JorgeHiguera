package miw.upm.es.klondike.JorgeHiguera.model;

import java.util.List;
import java.util.Map;

public class Game {
	
	private State state;
	
	private Board board;

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

	public void setDeck(List<Card> deck) {
		board.setDeck(deck);
	}

	public void setStrights(Map<Integer, List<Card>> strights) {
		board.setStrights(strights);
	}

	public void setState(State state) {
		this.state = state;;
	}

}
