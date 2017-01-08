package miw.upm.es.klondike.controller.local;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.model.Board;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;
import miw.upm.es.klondike.model.PlaceOfCard;

public class TestLocalMoveFromStrightToStrightController {

	private Game game;
	private LocalMoveFromStrightToStrightController localMoveFromStrightToStrightController;

	private void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromStrightToStrightController = new LocalMoveFromStrightToStrightController(game);
	}

	private int[] prepareTests(boolean goodTest) {
		boolean found = false;
		int[] strights = { 0, 0 };
		do {
			setUp();
			for (int i = 1; i <= Board.NUM_STRIGHTS && !found; i++) {
				List<Card> toPlaceCards = localMoveFromStrightToStrightController.getFaceUpCardsOfStright(i);
				for (int j = 1; j <= Board.NUM_STRIGHTS && !found; j++) {
					List<Card> placedCards = localMoveFromStrightToStrightController.getFaceUpCardsOfStright(j);

					Error error = localMoveFromStrightToStrightController.movedPermited(toPlaceCards, placedCards,
							PlaceOfCard.STRIGHT);
					found = (error == null && goodTest) || (error != null && !goodTest);
					strights[0] = i;
					strights[1] = j;
				}
			}
		} while (!found);
		return strights;
	}

	@Test
	public void testGoodMove() {
		try {
			int[] strights = prepareTests(true);
			assertTrue(localMoveFromStrightToStrightController.move(strights[0], strights[1]) == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			int[] strights = prepareTests(false);
			assertTrue(localMoveFromStrightToStrightController.move(strights[0],
					strights[1]) == Error.MOVEMENT_NOT_PERMITED);
		} catch (Exception e) {
			assert (false);
		}
	}

}
