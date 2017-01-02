package miw.upm.es.klondike.controller.local;

import miw.upm.es.klondike.controller.Error;
import miw.upm.es.klondike.controller.FaceUpCardInStrightController;
import miw.upm.es.klondike.controller.MoveCardControllerVisitor;
import miw.upm.es.klondike.controller.OperationControllerVisitor;
import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.Game;

public class LocalFaceUpInStrightController extends LocalPlaceCardController implements FaceUpCardInStrightController {

	public LocalFaceUpInStrightController(Game game) {
		super(game);
	}

	@Override
	public void accept(MoveCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move(int targetStright) {
		Card toFaceUp = super.getFirstCardOfStright(targetStright);
		Error error = super.faceUpPermited(toFaceUp);
		if (error == null) {
			super.faceUpCard(targetStright);
		} else {
			super.askOption();
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
