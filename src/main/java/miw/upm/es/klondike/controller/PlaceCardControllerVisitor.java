package miw.upm.es.klondike.controller;

public interface PlaceCardControllerVisitor {

	public void visit(MoveFromDeckToDiscardController moveFromDeckToDiscardController);
	
	public void visit(MoveFromDiscardToDeckController moveFromDiscardToDeckController);
	
	public void visit(MoveFromDiscardToStrightController moveFromDiscardToStrightController);
	
	public void visit(MoveFromStrightToStrightController moveFromStrightToStrightController);
	
	public void visit(MoveFromDiscardToSuitController moveFromDiscardToSuitController);
	
	public void visit(MoveFromStrightToSuitController moveFromStrightToSuitController);
	
	public void visit(MoveFromSuitToStrightController moveFromSuitToStrightController);
	
	public void visit(FaceUpCardInStrightController faceUpCardInStrightController);
}
