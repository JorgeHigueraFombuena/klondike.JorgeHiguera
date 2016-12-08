package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.PresenterController;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;

public class FinishedGameView {
	
	private String message;

	public FinishedGameView(String message){
		this.message = message;
	}
	
	public void write(){
		IO io = new IO();
		io.write(message);
	}
}
