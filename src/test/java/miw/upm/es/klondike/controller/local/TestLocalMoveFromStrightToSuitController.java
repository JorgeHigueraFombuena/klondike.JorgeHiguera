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

public class TestLocalMoveFromStrightToSuitController {

	private Game game;
	private LocalMoveFromStrightToSuitController localMoveFromStrightToSuitController;

	private void setUp() {
		game = new Game();
		LocalBuilderController localBuilderController = new LocalBuilderController(game);
		localBuilderController.build();
		localMoveFromStrightToSuitController = new LocalMoveFromStrightToSuitController(game);
	}

	private int prepareTests(boolean goodTest) {
		boolean found = false;
		int stright = 0;
		do {
			setUp();
			for (int i = 1; i <= Board.NUM_STRIGHTS && !found; i++) {
				Card toPlace = localMoveFromStrightToSuitController.getFirstCardOfStright(i);
				if (toPlace != null) {
					Card placed = localMoveFromStrightToSuitController.getFirstCardFromSuit(toPlace.getSuit());
					List<Card> toPlaceCards = new ArrayList<Card>();
					List<Card> placedCards = new ArrayList<Card>();
					if (toPlace != null) {
						toPlaceCards.add(toPlace);
					}
					if (placed != null) {
						placedCards.add(placed);
					}
					Error error = localMoveFromStrightToSuitController.movedPermited(toPlaceCards, placedCards,
							PlaceOfCard.SUIT);
					found = (error == null && goodTest) || (error != null && !goodTest);
					stright = i;
				}
			}
		} while (!found);
		return stright;
	}

	@Test
	public void testGoodMove() {
		try {
			int stright = prepareTests(true);
			assertTrue(localMoveFromStrightToSuitController.move(stright) == null);
		} catch (Exception e) {
			assert (false);
		}
	}

	@Test
	public void testBadMove() {
		try {
			int stright = prepareTests(false);
			assertTrue(localMoveFromStrightToSuitController.move(stright) == Error.MOVEMENT_NOT_PERMITED);
		} catch (Exception e) {
			assert (false);
		}
	}

}
