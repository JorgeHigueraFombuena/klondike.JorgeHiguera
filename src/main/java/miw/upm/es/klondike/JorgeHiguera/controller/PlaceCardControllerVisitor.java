package miw.upm.es.klondike.JorgeHiguera.controller;

public interface PlaceCardControllerVisitor {

	public void visit(MoveFromDeckToDiscardController moveFromDeckToDiscardController);
	
	public void visit(MoveFromDiscardToDeckController moveFromDiscardToDeckController);
	
	public void visit(MoveFromDiscardToStrightController moveFromDiscardToStrightController);
	
	public void visit(MoveFromStrightToStrightController moveFromStrightToStrightController);
}
