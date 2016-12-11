package miw.upm.es.klondike.JorgeHiguera.utils;

import miw.upm.es.klondike.JorgeHiguera.model.Suit;

public class LimitedSuitDialog {

	private ClosedSuitIntervalView limitView;

	public LimitedSuitDialog(){
		this.limitView = new ClosedSuitIntervalView("El valor debe estar entre ");
	}

	public Suit read(){
		IO io = new IO();
		boolean ok = false;
		String aux = null;
		try {
			this.limitView.writeln();
			aux = io.readString("");
			ok = Suit.valueOf(aux.toUpperCase()) != null;
		} catch(Exception e){}
		return ok ? Suit.valueOf(aux.toUpperCase()) : null;
	}
}
