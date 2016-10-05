package miw.upm.es.klondike.JorgeHiguera.controller;

import java.util.List;
import java.util.Map;

import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public interface PresenterController {

	public List<Card> getDeck();
	
	public List<Card> getDiscard();
	
	public Map<Integer, List<Card>> getStrights();
	
	public Map<Suit, List<Card>> getSuits();
	
}
