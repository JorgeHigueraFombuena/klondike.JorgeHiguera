package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.model.Board;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.utils.LimitedIntDialog;
import miw.upm.es.klondike.JorgeHiguera.utils.LimitedSuitDialog;

public class PositionView {

	private String title;
	
	private String limitDialogTitle;
	
	private int maxLimit;
	
	private int position;
	
	private Suit suit;
	
	private IO io;
	
	PositionView(String title, String limitDialogTitle,
			int maxLimit){
		assert title != null;
		assert limitDialogTitle != null;
		assert maxLimit > 0;
		this.title = title;
		this.limitDialogTitle = limitDialogTitle;
		this.maxLimit = maxLimit;
		io = new IO();
	}
	
	PositionView(String title, String limitDialogTitle){
		assert title != null;
		assert limitDialogTitle != null;
		this.title = title;
		this.limitDialogTitle = limitDialogTitle;
		io = new IO();
	}
	
	int getPosition(){
		return position;
	}
	
	Suit getSuit(){
		return suit;
	}
	
	void readInt(){
		io.writeln(title);
		position = new LimitedIntDialog(limitDialogTitle,
				maxLimit).read();
	}
	
	void readSuit(){
		io.writeln(title);
		suit = new LimitedSuitDialog(limitDialogTitle).read();
	}
	
}
