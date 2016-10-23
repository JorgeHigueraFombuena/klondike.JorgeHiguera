package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.FaceUpCardInStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public class LocalFaceUpInStrightController extends LocalPlaceCardController implements FaceUpCardInStrightController {

	public LocalFaceUpInStrightController(Game game) {
		super(game);
	}

	@Override
	public Error isStrightCorrect(int stright, Card card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(PlaceCardControllerVisitor colocateControllerVisitor) {
		colocateControllerVisitor.visit(this);
	}

	@Override
	public Error move(int targetStright) {
		Card toFaceUp = super.getFirstCardFromStright(targetStright);
		Error error = super.faceUpPermited(toFaceUp);
		if(error == null){
			super.faceUpCard(targetStright);
		}
		return error;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
