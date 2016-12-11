package miw.upm.es.klondike.view;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.FaceUpCardInStrightController;
import miw.upm.es.klondike.controller.MoveCardController;
import miw.upm.es.klondike.controller.MoveFromDeckToDiscardController;
import miw.upm.es.klondike.controller.MoveFromDiscardToDeckController;
import miw.upm.es.klondike.controller.MoveFromDiscardToStrightController;
import miw.upm.es.klondike.controller.MoveFromDiscardToSuitController;
import miw.upm.es.klondike.controller.MoveFromStrightToStrightController;
import miw.upm.es.klondike.controller.MoveFromStrightToSuitController;
import miw.upm.es.klondike.controller.MoveFromSuitToStrightController;
import miw.upm.es.klondike.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.model.FinishedMessages;
import miw.upm.es.klondike.model.Suit;
import miw.upm.es.klondike.utils.IO;

public class GameView implements PlaceCardControllerVisitor {

	public void interact(MoveCardController moveCardController) {
		moveCardController.accept(this);
	}

	@Override
	public void visit(MoveFromDeckToDiscardController moveFromDeckToDiscardController) {
		Error error = null;
		error = moveFromDeckToDiscardController.move();
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromDeckToDiscardController);
	}

	@Override
	public void visit(MoveFromDiscardToDeckController moveFromDiscardToDeckController) {
		Error error = null;
		error = moveFromDiscardToDeckController.move();
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromDiscardToDeckController);
	}

	@Override
	public void visit(MoveFromDiscardToStrightController moveFromDiscardToStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		int targetStright = view.getTargetStright();
		error = moveFromDiscardToStrightController.move(targetStright);
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromDiscardToStrightController);
	}

	private void showNextMessage(MoveCardController placeCardController) {
		if (placeCardController.gameFinished()) {
			new FinishedGameView(FinishedMessages.GOOD_FINISH.toString()).writeln();
			placeCardController.finishTheGame();
		} else {
			new BoardView(placeCardController).write();
			placeCardController.askOption();
		}
	}

	@Override
	public void visit(MoveFromStrightToStrightController moveFromStrightToStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		int originStright = view.getOriginStright();
		int targetStright = view.getTargetStright();

		error = moveFromStrightToStrightController.move(originStright, targetStright);
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromStrightToStrightController);
	}

	@Override
	public void visit(MoveFromDiscardToSuitController moveFromDiscardToSuitController) {
		Error error = moveFromDiscardToSuitController.move();
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromDiscardToSuitController);
	}

	@Override
	public void visit(MoveFromStrightToSuitController moveFromStrightToSuitController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		int originTarget = view.getOriginStright();
		error = moveFromStrightToSuitController.move(originTarget);
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromStrightToSuitController);
	}

	@Override
	public void visit(MoveFromSuitToStrightController moveFromSuitToStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		MoveSuitMovementView viewSuit = new MoveSuitMovementView();
		Error error = null;
		int targetStright = view.getTargetStright();
		Suit originSuit = viewSuit.getOriginSuit();

		error = moveFromSuitToStrightController.move(originSuit, targetStright);
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(moveFromSuitToStrightController);
	}

	@Override
	public void visit(FaceUpCardInStrightController faceUpCardInStrightController) {
		MoveStrightMovementView view = new MoveStrightMovementView();
		Error error = null;
		int targetStright = view.getTargetStright();
		error = faceUpCardInStrightController.move(targetStright);
		if (error != null) {
			(new IO()).writeError(error);
		}
		this.showNextMessage(faceUpCardInStrightController);
	}
}
