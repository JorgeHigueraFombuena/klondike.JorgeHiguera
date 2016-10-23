package miw.upm.es.klondike.JorgeHiguera.controller.local;

import miw.upm.es.klondike.JorgeHiguera.controller.Error;
import miw.upm.es.klondike.JorgeHiguera.controller.MoveFromStrightToStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.OperationControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardControllerVisitor;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Game;

public class LocalMoveFromStrightToStrightController extends LocalPlaceCardController
		implements MoveFromStrightToStrightController {

	public LocalMoveFromStrightToStrightController(Game game) {
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
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public Error move(int originStright, int targetStright) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(OperationControllerVisitor operationalControllerVisitor) {
		operationalControllerVisitor.visit(this);
	}

}
