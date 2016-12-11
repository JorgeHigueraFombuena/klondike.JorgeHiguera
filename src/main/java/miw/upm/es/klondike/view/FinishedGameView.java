package miw.upm.es.klondike.view;

import miw.upm.es.klondike.utils.IO;

public class FinishedGameView {
	
	private String message;

	public FinishedGameView(String message){
		this.message = message;
	}
	
	public void writeln(){
		IO io = new IO();
		io.writeln(message);
	}
}
