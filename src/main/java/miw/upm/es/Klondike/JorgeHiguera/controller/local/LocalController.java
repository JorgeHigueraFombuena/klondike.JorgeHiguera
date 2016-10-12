package miw.upm.es.Klondike.JorgeHiguera.controller.local;

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
	}
	
	public void moveFromDiscardToDeck(){
		game.moveFromDiscardToDeck();
	}
	
	public Error validateEmptyDeck(){
		if(!game.isEmptyDeck()){
			return Error.DECK_NO_EMPTY;
		}
		return Error.DECK_EMPTY;
	}
	
	public Error validateEmptyDiscard(){
		if(!game.isEmptyDiscard()){
			return Error.DISCARD_EMPTY;
		}
		return Error.DISCARD_NO_EMPTY;
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
	
	public Map<Integer, List<Card>> getStrights(){
		return game.getStrights();
	}
	
	public Map<Suit, List<Card>> getSuits(){
		return game.getSuits();
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
	
}
