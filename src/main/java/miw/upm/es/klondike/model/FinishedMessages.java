package miw.upm.es.klondike.model;

public enum FinishedMessages {
	GOOD_FINISH("Juego teminado! Has ganado"),
	BAD_FINISH("Ohhhh! Que pena... Has perdido. No se pueden hacer más movimientos");
	
	private String message;
	
	FinishedMessages(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
