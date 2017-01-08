package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;
import miw.upm.es.klondike.model.Suit;

public class TestLocalMoveFromSuitToStrightController {

	private Game game;
	private LocalMoveFromSuitToStrightController localMoveFromSuitToStrightController;
	private Suit suit = Suit.BASTOS;

	private void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromSuitToStrightController = new LocalMoveFromSuitToStrightController(game);
	}

	private void prepareTests(boolean goodTest) {
		boolean found = false;
		setUp();
		if (goodTest) {
			game.getStrights().get(1).clear();
			game.getSuits().get(suit).add(new Card(suit, 12, PlaceOfCard.SUIT));
		} else {
			game.getStrights().get(1).clear();
			game.getSuits().get(suit).add(new Card(suit, 5, PlaceOfCard.SUIT));
		}
	}

	@Test
	public void testGoodMove() {
		try {
			prepareTests(true);
			assertTrue(localMoveFromSuitToStrightController.move(suit, 1) == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			prepareTests(false);
			assertTrue(localMoveFromSuitToStrightController.move(suit, 1) == Error.MOVEMENT_NOT_PERMITED);
		} catch (Exception e) {
			assert (false);
		}
	}

}
