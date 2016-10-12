package miw.upm.es.klondike.JorgeHiguera.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	Card c;
	
	@Before
	public void before(){
		c = new Card(Suit.BASTOS, 4);
	}

	@Test
	public void testCard() {
		Card c = new Card(Suit.BASTOS, 4);
		assertEquals(Suit.BASTOS, c.getSuit());
		assertEquals(4, c.getNumber());
	}

	@Test
	public void testGetSuit() {
		assertEquals(Suit.BASTOS, c.getSuit());
	}

	@Test
	public void testGetNumber() {
		assertEquals(4, c.getNumber());
	}

}
