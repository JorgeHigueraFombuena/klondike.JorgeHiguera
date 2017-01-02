package miw.upm.es.klondike.controller;

import java.util.List;

import miw.upm.es.klondike.model.Card;
import miw.upm.es.klondike.model.PlaceOfCard;

public interface PlaceCardController extends MoveCardController {

	public Error faceUpPermited(Card toFaceUp);

	Error movedPermited(List<Card> toPlaceCards, List<Card> placedCards, PlaceOfCard targerPlace);

}
