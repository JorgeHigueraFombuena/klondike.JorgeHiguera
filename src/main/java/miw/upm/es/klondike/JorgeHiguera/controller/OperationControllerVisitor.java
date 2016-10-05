package miw.upm.es.klondike.JorgeHiguera.controller;

public interface OperationControllerVisitor {
	
	public void visit(StartController startController);
	
	public void visit(ColocateController colocateController);


}
