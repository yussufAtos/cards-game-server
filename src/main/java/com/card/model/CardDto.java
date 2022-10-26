package com.card.model;

import java.util.List;

public class CardDto {

	private List<Card> randomHand;
	private List<Card> sortedCards;
	private List<String> colorsOrder;
	private List<String> valuesOrder;

	
	public List<Card> getSortedCards() {
		return sortedCards;
	}

	public void setSortedCards(List<Card> sortedCards) {
		this.sortedCards = sortedCards;
	}

	public CardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Card> getRandomHand() {
		return randomHand;
	}

	public void setRandomHand(List<Card> randomHand) {
		this.randomHand = randomHand;
	}

	public List<String> getColorsOrder() {
		return colorsOrder;
	}

	public void setColorsOrder(List<String> colorsOrder) {
		this.colorsOrder = colorsOrder;
	}

	public List<String> getValuesOrder() {
		return valuesOrder;
	}

	public void setValuesOrder(List<String> valuesOrder) {
		this.valuesOrder = valuesOrder;
	}

}
