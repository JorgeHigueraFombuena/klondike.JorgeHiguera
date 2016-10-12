package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;

public class GameView implements PlaceCardControllerVisitor{

	public void interact(PlaceCardController placeCardController){
		placeCardController.accept(this);
	}
	
	@Override
	public void visit(MoveFromDeckToDiscardController moveFromDeckToDiscardController) {
		moveFromDeckToDiscardController.move();
		this.showBoard(moveFromDeckToDiscardController);
	}

	@Override
	public void visit(MoveFromDiscardToDeckController moveFromDiscardToDeckController) {
		moveFromDiscardToDeckController.move();
		this.showBoard(moveFromDiscardToDeckController);
	}
	
	private void showBoard(PlaceCardController placeCardController){
		new BoardView(placeCardController).write();
		placeCardController.askOption();
	}
}