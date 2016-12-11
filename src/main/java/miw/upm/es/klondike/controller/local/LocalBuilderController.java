package miw.upm.es.klondike.controller.local;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import miw.upm.es.klondike.controller.BuilderController;
import miw.upm.es.klondike.controller.OperationController;
import miw.upm.es.klondike.model.Board;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.Options;
import miw.upm.es.klondike.model.PlaceOfCard;
import miw.upm.es.klondike.model.Suit;

public class LocalBuilderController implements BuilderController {

	private Game game;

	private LocalOperationController[] operations;

	public LocalBuilderController(Game game) {
		assert game != null;
		this.game = game;
	}

	@Override
	public void build() {
		List<Card> deck = initDeck();
		game.setStrights(initStrights(deck));
		game.setDeck(deck);
		initAskOperation();
	}

	private void initAskOperation() {
		operations = new LocalOperationController[Options.values().length];
		for (Options option : Options.values()) {
			operations[option.ordinal()] = getMoveController(option);
		}
	}

	private LocalOperationController getMoveController(Options option) {
		switch (option) {
		case FROM_DECK_TO_DISCARD:
			return new LocalMoveFromDeckToDiscardController(game);
		case FROM_DISCARD_TO_DECK:
			return new LocalMoveFromDiscardToDeckController(game);
		case FROM_DISCARD_TO_STRIGHT:
			return new LocalMoveFromDiscardToStrightController(game);
		case FROM_STRIGHT_TO_STRIGHT:
			return new LocalMoveFromStrightToStrightController(game);
		case FROM_DISCARD_TO_SUIT:
			return new LocalMoveFromDiscardToSuitController(game);
		case FROM_STRIGHT_TO_SUIT:
			return new LocalMoveFromStrightToSuitController(game);
		case FROM_SUIT_TO_STRIGHT:
			return new LocalMoveFromSuitToStrightController(game);
		case FACE_UP_IN_STRIGHT:
			return new LocalFaceUpInStrightController(game);
		default:
			return null;
		}
	}

	private Map<Integer, List<Card>> initStrights(List<Card> deck) {
		Map<Integer, List<Card>> strights = new HashMap<Integer, List<Card>>();
		for (int i = Board.NUM_STRIGHTS; i >= 1; i--) {
			List<Card> stright = new ArrayList<Card>();
			for (int j = 0; j < i; j++) {
				if (j == i - 1) {
					deck.get(j).setFaceDown(false);
				}
				deck.get(j).setPlaceOfCard(PlaceOfCard.STRIGHT);
				stright.add(deck.get(j));
			}
			deck.removeAll(stright);
			strights.put(i, stright);
		}
		return strights;
	}

	private List<Card> initDeck() {
		List<Card> list = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			list.addAll(initSuit(suit));
		}
		Collections.shuffle(list);
		return list;
	}

	private List<Card> initSuit(Suit suit) {
		List<Card> list = new ArrayList<Card>();
		for (int i = 1; i <= Board.NUM_CARDS_PER_SUIT; i++) {
			list.add(new Card(suit, i, PlaceOfCard.DECK, true));
		}
		return list;
	}

	public LocalOperationController getOperationController(Options option) {
		return operations[option.ordinal()];
	}

	public OperationController getAskOperationController() {
		return new LocalAskOperationController(game);
	}
}
