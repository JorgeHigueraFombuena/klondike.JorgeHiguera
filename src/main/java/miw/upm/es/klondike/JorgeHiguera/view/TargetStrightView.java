package miw.upm.es.klondike.JorgeHiguera.view;

import miw.upm.es.klondike.JorgeHiguera.controller.MoveCardStrightController;
import miw.upm.es.klondike.JorgeHiguera.controller.PlaceCardController;
import miw.upm.es.klondike.JorgeHiguera.model.Card;
import miw.upm.es.klondike.JorgeHiguera.model.Options;
import miw.upm.es.klondike.JorgeHiguera.utils.LimitedIntDialog;

public class TargetStrightView {
	
	public int getStright(MoveCardStrightController moveCardStrightController,
			Card card){
		int stright = new LimitedIntDialog("A qué escalera?", 1, 
				moveCardStrightController.getSuits().size()).read() - 1;
		moveCardStrightController.isStrightCorrect(stright, card);
		return stright;
	}

}
