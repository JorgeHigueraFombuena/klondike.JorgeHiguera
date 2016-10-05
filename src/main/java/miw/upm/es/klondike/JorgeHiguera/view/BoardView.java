package miw.upm.es.klondike.JorgeHiguera.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import miw.upm.es.klondike.JorgeHiguera.controller.PresenterController;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;

public class BoardView {

	private PresenterController controller;

	public BoardView(PresenterController controller){
		assert controller != null;
		this.controller = controller;
	}

	public void write(){
		writeDeck(controller.getDeck());
		writeDiscard(controller.getDiscard());
		writeSuits(controller.getSuits());
		writeStrights(controller.getStrights());
	}

	private void writeDeck(List<Card> deck) {
		IO io = new IO();
		io.write("Baraja: ");
		if(deck.isEmpty()){
			io.writeEmpty();
		}
		else{
			(new CardView(deck.get(0))).write();
		}
		io.writeln();
	}

	private void writeDiscard(List<Card> discard) {
		IO io = new IO();
		io.write("Descarte: ");
		if(discard.isEmpty()){
			io.writeEmpty();
		}
		else{
			for(Card card : discard){
				(new CardView(card)).write();
			}
		}
		io.writeln();
	}

	private void writeStrights(Map<Integer, List<Card>> strights) {
		IO io = new IO();
		for(Entry<Integer, List<Card>> entry : strights.entrySet()){
			io.write("Escalera " + entry.getKey() + ": ");
			writeListOfCards(entry.getValue());
			io.writeln();
		}
	}

	private void writeSuits(Map<Suit, List<Card>> suits) {
		IO io = new IO();
		for(Entry<Suit, List<Card>> entry : suits.entrySet()){
			io.write("Palo " + entry.getKey().toString() + ": ");
			if(entry.getValue().isEmpty()){
				io.writeEmpty();
			}
			writeListOfCards(entry.getValue());
			io.writeln();
		}
	}
	
	private void writeListOfCards(List<Card> list){
		for(Card card : list){
			(new CardView(card, true, 
					isLastCardOfStright(card, list))).write();
		}
	}
	
	private boolean isLastCardOfStright(Card card, List<Card> list){
		return list.get(list.size()-1).equals(card);
	}

}
