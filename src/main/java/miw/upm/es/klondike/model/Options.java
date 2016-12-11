package miw.upm.es.klondike.model;

public enum Options {
	FROM_DECK_TO_DISCARD("1. Mover de baraja a descarte"),
	FROM_DISCARD_TO_DECK("2. Mover de descarte a baraja"),
	FROM_DISCARD_TO_SUIT("3. Mover de descarte a palo"),
	FROM_DISCARD_TO_STRIGHT("4. Mover de descarte a escalera"),
	FROM_STRIGHT_TO_SUIT("5. Mover de escalera a palo"),
	FROM_STRIGHT_TO_STRIGHT("6. Mover de escalera a escalera"),
	FROM_SUIT_TO_STRIGHT("7. Mover de palo a escalera"),
	FACE_UP_IN_STRIGHT("8. Voltear en escalera"),
	EXIT("9. Salir");
	
	private String message;
	
	Options(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
