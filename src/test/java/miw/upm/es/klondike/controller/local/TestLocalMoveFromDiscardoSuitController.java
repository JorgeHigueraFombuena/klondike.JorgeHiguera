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

public class TestLocalMoveFromDiscardoSuitController {

	private Game game;
	private LocalMoveFromDiscardToSuitController localMoveFromDicardToSuitController;
	private LocalMoveFromDeckToDiscardController localMoveFromDeckToDiscardController;

	private void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromDicardToSuitController = new LocalMoveFromDiscardToSuitController(game);
		localMoveFromDeckToDiscardController = new LocalMoveFromDeckToDiscardController(game);
		localMoveFromDeckToDiscardController.move();
	}

	private void prepareTests(boolean goodTest) {
		boolean found = false;
		do {
			setUp();
			Card cardFromDiscard = game.getFirstCardFromDiscard();
			List<Card> cardsFromDiscard = new ArrayList<Card>();
			cardsFromDiscard.add(cardFromDiscard);
			for (int i = 1; i < Board.NUM_STRIGHTS && !found; i++) {
				Card toPlace = game.getFirstCardFromDiscard();
				Card placed = game.getFirstCardFromSuit(toPlace.getSuit());
				List<Card> toPlaceCards = new ArrayList<Card>();
				List<Card> placedCards = new ArrayList<Card>();
				if (toPlace != null) {
					toPlaceCards.add(toPlace);
				}
				if (placed != null) {
					placedCards.add(placed);
				}
				Error error = localMoveFromDicardToSuitController.movedPermited(toPlaceCards, placedCards,
						PlaceOfCard.SUIT);
				found = (error == null && goodTest) || (error != null && !goodTest);
			}
		} while (!found);
	}

	@Test
	public void testGoodMove() {
		try {
			prepareTests(true);
			assertTrue(localMoveFromDicardToSuitController.move() == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			prepareTests(false);
			assertTrue(localMoveFromDicardToSuitController.move() == Error.MOVEMENT_NOT_PERMITED);
		} catch (Exception e) {
			assert (false);
		}
	}
}
