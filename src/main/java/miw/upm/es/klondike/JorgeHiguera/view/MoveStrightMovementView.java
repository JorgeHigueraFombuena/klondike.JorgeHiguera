package miw.upm.es.klondike.JorgeHiguera.view;

public abstract class MoveStrightMovementView extends MovementView {

	private int stright;
	
	public MoveStrightMovementView(MovementController movementController) {
		super(movementController);
	}
	
	int getPosition(){
		stright = this.getMovementController().getOriginStright();
		this.getMovementController().accept(this);
		return stright;
	}
}
