package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Suit;
import miw.upm.es.klondike.JorgeHiguera.utils.IO;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromDiscardToSuitController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromStrightToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromStrightToSuitController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromSuitToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;

import java.awt.PageAttributes.OriginType;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.FaceUpCardInStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveCardController;

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
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		do{
			int targetStright = view.getTargetStright();
			error = moveFromDiscardToStrightController.move(targetStright);
			if(error != null){
				new IO().writeln("Error: " + error.toString());
			}
		} while(error != null);
		this.showBoard(moveFromDiscardToStrightController);
	}
	
	private void showBoard(MoveCardController placeCardController){
		new BoardView(placeCardController).write();
	}

	@Override
	public void visit(MoveFromStrightToStrightController moveFromStrightToStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		do{
			int originStright = view.getOriginStright();
			int targetStright = view.getTargetStright();
			
			error = moveFromStrightToStrightController.move(originStright, targetStright);
			if(error != null){
				new IO().writeln("Error: " + error.toString());
			}
		} while(error != null);
		this.showBoard(moveFromStrightToStrightController);
	}

	@Override
	public void visit(MoveFromDiscardToSuitController moveFromDiscardToSuitController) {
		moveFromDiscardToSuitController.move();
		this.showBoard(moveFromDiscardToSuitController);
	}

	@Override
	public void visit(MoveFromStrightToSuitController moveFromStrightToSuitController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		do{
			int originTarget = view.getOriginStright();
			error = moveFromStrightToSuitController.move(originTarget);
			if(error != null){
				new IO().writeln("Error: " + error.toString());
			}
		} while(error != null);
		this.showBoard(moveFromStrightToSuitController);
	}

	@Override
	public void visit(MoveFromSuitToStrightController moveFromSuitToStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		MoveSuitMovementView viewSuit = new MoveSuitMovementView();
		Error error = null;
		do{
			int targetStright = view.getTargetStright();
			Suit originSuit = viewSuit.getOriginSuit();
			
			error = moveFromSuitToStrightController.move(originSuit, targetStright);
			if(error != null){
				new IO().writeln("Error: " + error.toString());
			}
		} while(error != null);
		this.showBoard(moveFromSuitToStrightController);
	}

	@Override
	public void visit(FaceUpCardInStrightController faceUpCardInStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		do{
			int targetStright = view.getTargetStright();
			error = faceUpCardInStrightController.move(targetStright);
			if(error != null){
				new IO().writeln("Error: " + error.toString());
			}
		} while(error != null);
		this.showBoard(faceUpCardInStrightController);
	}
}
