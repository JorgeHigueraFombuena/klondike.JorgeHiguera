package miw.upm.es.Klondike.JorgeHiguera.controller.local;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import miw.upm.es.klondike.JorgeHiguera.controller.BuilderController;
import miw.upm.es.klondike.JorgeHiguera.model.Board;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public class LocalBuilderController implements BuilderController{

	private Game game;

	public LocalBuilderController(Game game){
		assert game != null;
		this.game = game;
	}

	public void build() {
		List<Card> deck = initDeck();
		game.setDeck(deck);
		game.setStrights(initStrights(deck));
		
	}

	private Map<Integer, List<Card>> initStrights(List<Card> deck){
		Map<Integer, List<Card>> strights = new HashMap<Integer, List<Card>>(); 
		for(int i = Board.NUM_STRIGHTS; i >= 1; i--){
			List<Card> stright = new ArrayList<Card>();
			for(int j = 0; j < i; j++){
				if(j == i - 1){
					deck.get(j).setFaceDown(false);
				}
				stright.add(deck.get(j));
			}
			deck.removeAll(stright);
			strights.put(i, stright);
		}
		return strights;
	}
	
	private List<Card> initDeck(){
		List<Card> list = new ArrayList<Card>();
		for(Suit suit : Suit.values()){
			list.addAll(initSuit(suit));
		}
		Collections.shuffle(list);
		return list;
	}
	
	private List<Card> initSuit(Suit suit){
		List<Card> list = new ArrayList<Card>();
		Random rand = new Random();
		int randomNum = 0;
		while(list.size() != Board.NUM_CARDS_PER_SUIT){
			randomNum = rand.nextInt((Board.NUM_CARDS_PER_SUIT - 1) + 1) + 1;
			if(!list.contains(new Card(suit, randomNum, true))){
				list.add(new Card(suit, randomNum, true));
			}
		}
		return list;
	}
}
