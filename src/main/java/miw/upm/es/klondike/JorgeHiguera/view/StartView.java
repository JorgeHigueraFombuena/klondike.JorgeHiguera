package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.StartController;

public class StartView{

	void interact(StartController startController){
		startController.start();
		new BoardView(startController).write();
	}

}
