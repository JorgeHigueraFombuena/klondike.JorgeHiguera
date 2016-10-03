package miw.upm.es.klondike.JorgeHiguera;

public class Klondike {

	private Logic logic;
	
	private View view;
	
	public Klondike(Logic logic, View view){
		this.logic = logic;
		this.view = view;
	}
	
	public void play(){}
	
	
	public static void main(String[] args) {
		(new Klondike()).play();
	}

	
}
