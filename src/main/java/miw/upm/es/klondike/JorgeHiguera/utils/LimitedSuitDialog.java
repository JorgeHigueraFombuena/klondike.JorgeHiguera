package miw.upm.es.klondike.JorgeHiguera.utils;

import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public class LimitedSuitDialog {

	private String title;
	
	private ClosedSuitIntervalView limitView;
	
	public LimitedSuitDialog(String title){
		this.title = title;
	}
	
	public Suit read(){
		IO io = new IO();
		boolean ok;
		String aux;
		do {
			 aux = io.readString(title);
			ok = Suit.valueOf(aux) != null;
			if (!ok) {
				limitView.writeln();
			}
		} while (!ok);
		return Suit.valueOf(aux);
	}
}
