package miw.upm.es.klondike.JorgeHiguera.controller;

public enum Error {
	
	DECK_NO_EMPTY("La baraja no está vacía"),
	DECK_EMPTY("La baraja está vacía"),
	DISCARD_NO_EMPTY("El descarte no está vacío"),
	DISCARD_EMPTY("El descarte está vacío"),
	MOVEMENT_NOT_PERMITED("Movimiento no permitido");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
