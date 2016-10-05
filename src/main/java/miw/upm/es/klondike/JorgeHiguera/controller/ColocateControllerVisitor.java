package miw.upm.es.klondike.JorgeHiguera.controller;

public interface ColocateControllerVisitor {

	public void visit(MoveFromDeckToDiscardController moveFromDeckToDiscardController);
	
	public void visit(MoveFromDiscardToDeckController moveFromDiscardToDeckController);
	
}
