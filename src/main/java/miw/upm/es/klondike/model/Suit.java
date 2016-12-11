package miw.upm.es.klondike.model;

public enum Suit {
	COPAS("copas"), OROS("oros"), BASTOS("bastos"), ESPADAS("espadas");

	private String message;

	private Suit(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}
