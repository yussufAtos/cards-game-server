package com.card.service;

import java.util.List;

import com.card.model.Card;

public interface CardService {
	
	List<Card> createRandomHand();
	List<Card> creatSortedHandByColorAndValue();
	

}
