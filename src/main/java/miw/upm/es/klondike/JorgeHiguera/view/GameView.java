package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;

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

	@Override
	public void visit(MoveFromDiscardToStrightController moveFromDiscardToStrightController) {
		// TODO Auto-generated method stub
		MoveOriginStrightMovementView view = new MoveOriginStrightMovementView();
		Error error = null;
		do{
			int targetStright = view.getStright();
			error = moveFromDiscardToStrightController.move(targetStright);
			if(error != null){
				new IO().writeln("Error: " + error);
			}
		} while(error != null);
		this.showBoard(moveFromDiscardToStrightController);
	}
	
	private void showBoard(PlaceCardController placeCardController){
		new BoardView(placeCardController).write();
	}
}
