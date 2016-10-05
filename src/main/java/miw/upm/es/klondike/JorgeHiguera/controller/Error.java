package miw.upm.es.klondike.JorgeHiguera.controller;

public enum Error {
	
	DECK_NO_EMPTY("La baraja no está vacía"),
	DISCARD_EMPTY("El descarte está vacío");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
