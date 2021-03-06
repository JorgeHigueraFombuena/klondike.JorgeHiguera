package miw.upm.es.klondike.model;

import java.util.List;
import java.util.Map;

public class Game {

	private State state;

	private Board board;

	private Options optionSelected;

	public Game() {
		state = State.INITIAL;
		board = new Board();
	}

	public void moveFromDeckToDiscard() {
		board.moveFromDeckToDiscard();
	}

	public boolean isEmptyDeck() {
		return board.isEmptyDeck();
	}

	public List<Card> getDeck() {
		return board.getDeck();
	}

	public List<Card> getDiscard() {
		return board.getDiscard();
	}

	public Map<Integer, List<Card>> getStrights() {
		return board.getStrights();
	}

	public Map<Suit, List<Card>> getSuits() {
		return board.getSuits();
	}

	public State getState() {
		return state;
	}

	public Options getOptionSelected() {
		return optionSelected;
	}

	public void setDeck(List<Card> deck) {
		board.setDeck(deck);
	}

	public void setStrights(Map<Integer, List<Card>> strights) {
		board.setStrights(strights);
	}

	public void setState(State state) {
		this.state = state;
		;
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

	public List<Card> getFaceUpCardsOfStright(int stright) {
		return board.getFaceUpCardsOfStright(stright);
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

	public Card getFirstCardFromSuit(Suit suit) {
		return board.getFirstCardFromSuit(suit);
	}

	public void moveFromDiscardToSuit(Card toPlace) {
		board.moveFromDiscardToSuit(toPlace);
	}

	public void moveFromStrightToSuit(int originStright) {
		board.moveFromStrightToSuit(originStright);
	}

	public void moveFromSuitToStright(Suit originSuit, int targetStright) {
		board.moveFromSuitToStright(originSuit, targetStright);
	}

	public void faceUpCard(int targetStright) {
		board.faceUpCard(targetStright);
	}

	public Card getFirstCardOfStright(int stright) {
		return board.getFirstCardOfStright(stright);
	}

	public boolean gameFinished() {
		return board.gameFinished();
	}

	public void finishTheGame() {
		state = State.FINISHED;
	}

}
