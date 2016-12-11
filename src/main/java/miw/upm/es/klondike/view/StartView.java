package miw.upm.es.klondike.view;

import miw.upm.es.klondike.controller.StartController;

public class StartView{

	void interact(StartController startController){
		startController.start();
		new BoardView(startController).write();
	}

}
