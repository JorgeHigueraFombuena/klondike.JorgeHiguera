package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.model.Board;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.utils.LimitedIntDialog;

public class PositionView {

	private String title;
	
	private String limitDialogTitle;
	
	private int maxLimit;
	
	private int position;
	
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
	
	int getPosition(){
		return position;
	}
	
	void read(){
		io.writeln(title);
		position = new LimitedIntDialog(limitDialogTitle,
				maxLimit).read();
	}
	
}
