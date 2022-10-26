package com.card.service;

import java.util.List;

import com.card.model.Card;
import com.card.model.CardDto;

public interface CardService {
	
	List<Card> createRandomHand();
	List<Card> creatSortedHandByColorAndValue(List<String> randomColors, List<String> randomValues,
			List<Card> hand);
	CardDto playCards();
	

}
