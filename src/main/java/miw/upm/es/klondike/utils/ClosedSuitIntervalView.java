package miw.upm.es.klondike.utils;

import miw.upm.es.klondike.model.Suit;

public class ClosedSuitIntervalView {

	private String title;

	private IO io;

	public ClosedSuitIntervalView(String title) {
		assert title != null;
		this.title = title;
		io = new IO();
	}

	public void writeln() {
		io.writeln(title + " " + this.toString());
	}

	@Override
	public String toString() {
		String str = "[";
		for (int i = 0; i < Suit.values().length; i++) {
			str += Suit.values()[i] + ",";
		}
		return str.substring(0, str.length() - 1) + "]";
	}
}
