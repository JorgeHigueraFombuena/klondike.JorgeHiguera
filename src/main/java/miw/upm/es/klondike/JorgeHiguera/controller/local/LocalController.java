package miw.upm.es.klondike.JorgeHiguera.controller.local;

import java.util.List;
import java.util.Map;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;
import miw.upm.es.klondike.JorgeHiguera.model.State;

public class LocalController {

	private Game game;
	
	public LocalController(Game game){
		assert game != null;
		this.game = game;
	}
	
	public void moveFromDeckToDiscard(){
		game.moveFromDeckToDiscard();
		askOption();
	}
	
	public void moveFromDiscardToDeck(){
		game.moveFromDiscardToDeck();
		askOption();
	}
	
	public Error validateEmptyDeck(){
		if(!game.isEmptyDeck()){
			return Error.DECK_NO_EMPTY;
		}
		return Error.DECK_EMPTY;
	}
	
	public Error validateEmptyDiscard(){
		if(!game.isEmptyDiscard()){
			return Error.DISCARD_NO_EMPTY;
		}
		return Error.DISCARD_EMPTY;
	}
	
	public List<Card> getFaceUpCardsOfStright(int stright){
		return game.getFaceUpCardsOfStright(stright);
	}
	
	public Card getFirstCardOfStright(int stright){
		return game.getFirstCardOfStright(stright);
	}
	
	public Card getFirstCardFromDiscard() {
		return game.getFirstCardFromDiscard();
	}
	
	public Options getOptionSelected(){
		return game.getOptionSelected();
	}
	
	public List<Card> getDeck(){
		return game.getDeck();
	}
	
	public List<Card> getDiscard(){
		return game.getDiscard();
	}
		
	public State getState(){
		return game.getState();
	}
	
	public void setState(State state){
		game.setState(state);
	}
	
	void changeAskOption(int option){
		game.changeAskOption(option);
	}
	
	Options getSelectedOption(){
		return game.getOptionSelected();
	}
	
	public int getNumStrights(){
		return game.getNumStrights();
	}
	
	public Map<Suit, List<Card>> getSuits() {
		return game.getSuits();
	}

	public Map<Integer, List<Card>> getStrights() {
		return game.getStrights();
	}
	
	public void move(Card toPlace, int stright){
		game.moveFromDiscardToStright(toPlace, stright);
		this.setState(State.ASK_OPERATION);
	}
	
	public void moveFromStrightToStright(int originStright, int targetStright){
		game.moveFromStrightToStright(originStright, targetStright);
		this.askOption();
	}
	
	public void changeState() {
		if(this.getSelectedOption() != Options.EXIT){
			this.setState(State.IN_GAME);
		}
		else{
			this.setState(State.FINISHED);
		}
	}
	
	public void askOption(){
		this.setState(State.ASK_OPERATION);
	}
	
	public Card getFirstCardFromSuit(Suit suit){
		return game.getFirstCardFromSuit(suit);
	}
	
	public void moveFromDiscardToSuit(Card toPlace){
		game.moveFromDiscardToSuit(toPlace);
		askOption();
	}
	
	public void moveFromStrightToSuit(int originStright) {
		game.moveFromStrightToSuit(originStright);
		askOption();
	}
	
	public void moveFromSuitToStright(Suit originSuit, int targetStright) {
		game.moveFromSuitToStright(originSuit, targetStright);
		askOption();
	}
	
	public void faceUpCard(int targetStright) {
		game.faceUpCard(targetStright);
		askOption();
	}
	
	public boolean gameFinished(){
		return game.gameFinished();
	}
	
	public void finishTheGame(){
		game.finishTheGame();
	}
}
