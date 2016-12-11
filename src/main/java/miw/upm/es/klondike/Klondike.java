package miw.upm.es.klondike;

import miw.upm.es.klondike.controller.OperationController;
import miw.upm.es.klondike.controller.local.LocalLogic;
import miw.upm.es.klondike.view.KlondikeView;

public class Klondike {

	private Logic logic;
	
	private View view;
	
	public Klondike(Logic logic, View view){
		this.logic = logic;
		this.view = view;
	}
	
	public void play(){
		OperationController controller;
		do {
			controller = logic.getOperationController();
			if(controller != null){
				view.interact(controller);
			}
		} while(controller != null);
	}
	
	
	public static void main(String[] args) {
		(new Klondike(new LocalLogic(), new KlondikeView())).play();
	}

	
}
