package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.model.Board;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public class TestLocalMoveFromDiscardToStrightController {

	private Game game;
	private LocalMoveFromDiscardToStrightController localMoveFromDicardToStrightController;
	private LocalMoveFromDeckToDiscardController localMoveFromDeckToDiscardController;

	private void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromDicardToStrightController = new LocalMoveFromDiscardToStrightController(game);
		localMoveFromDeckToDiscardController = new LocalMoveFromDeckToDiscardController(game);
		localMoveFromDeckToDiscardController.move();
	}

	private int prepareTests(boolean goodTest) {
		boolean found = false;
		int stright = -1;
		do {
			setUp();
			Card cardFromDiscard = game.getFirstCardFromDiscard();
			List<Card> cardsFromDiscard = new ArrayList<Card>();
			cardsFromDiscard.add(cardFromDiscard);
			for (int i = 1; i < Board.NUM_STRIGHTS && !found; i++) {
				List<Card> cardFromStright = game.getFaceUpCardsOfStright(i);
				Error error = localMoveFromDicardToStrightController.movedPermited(cardsFromDiscard, cardFromStright,
						PlaceOfCard.STRIGHT);
				found = (error == null && goodTest) || (error != null && !goodTest);
				stright = i;
			}
		} while (!found);
		return stright;
	}

	@Test
	public void testGoodMove() {
		try {
			int stright = prepareTests(true);
			assertTrue(localMoveFromDicardToStrightController.move(stright) == null);
		} catch (Exception e) {
			e.printStackTrace();
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			int stright = prepareTests(false);
			assertTrue(localMoveFromDicardToStrightController.move(stright) == Error.MOVEMENT_NOT_PERMITED);
		} catch (Exception e) {
			e.printStackTrace();
			assert (false);
		}
	}
}
