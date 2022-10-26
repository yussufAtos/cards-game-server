package com.card.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.card.model.Card;
import com.card.model.CardDto;
import com.card.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	private static final List<String> colors = List.of("Carreaux", "Coeur", "Pique", "Trèfle");
	private static final List<String> values = List.of("AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Dame",
			"Roi", "Valet");
	private static final Integer HAND_NUMBER = 10;
	
	public CardDto playCards() {

		List<Card> randomHamd = createRandomHand();
		List<String> colorsOrder = createRandomColor();
		List<String> valuesOrder = createRandomValue();
		List<Card> sortedCards = creatSortedHandByColorAndValue(colorsOrder,valuesOrder,randomHamd);
		System.out.println("valuesOrder :  " + valuesOrder);
		System.out.println("colorsOrder :  " + colorsOrder);
		System.out.println("randomHand  :  " + randomHamd);
		System.out.println("sortedCards  : " + sortedCards);

		CardDto cardDto = new CardDto();
		cardDto.setRandomHand(randomHamd);
		cardDto.setColorsOrder(colorsOrder);
		cardDto.setValuesOrder(valuesOrder);
		cardDto.setSortedCards(sortedCards);
		return cardDto;
	}

	@Override
	public List<Card> createRandomHand() {
		List<Card> cards = creatCards();
		List<Card> hand = new ArrayList<Card>();
		Random rand = new Random();
		for (int j = 0; j < HAND_NUMBER; j++) {
			int randomIndex = rand.nextInt(cards.size());
			hand.add(cards.get(randomIndex));
			cards.remove(randomIndex);
		}

		return hand;

	}

	public List<Card> creatSortedHandByColorAndValue(List<String> randomColors, List<String> randomValues,
			List<Card> hand) {

		Comparator<Card> colorComparator = (c1, c2) -> randomColors.indexOf(c1.getColor())
				- randomColors.indexOf(c2.getColor());
		Comparator<Card> valueComparator = (c1, c2) -> randomValues.indexOf(c1.getValue())
				- randomValues.indexOf(c2.getValue());

		List<Card> sortedHand = hand.stream().sorted(colorComparator.thenComparing(valueComparator))
				.collect(Collectors.toList());

		return sortedHand;
	}

	private List<String> createRandomColor() {

		List<String> colorsCopy = new ArrayList<String>(colors);
		List<String> randomColors = new ArrayList<String>();

		Random rand = new Random();
		for (int j = 0; j < colors.size(); j++) {
			int randomIndex = rand.nextInt(colorsCopy.size());
			randomColors.add(colorsCopy.get(randomIndex));
			colorsCopy.remove(randomIndex);
		}

		return randomColors;
	}

	private List<String> createRandomValue() {

		List<String> valuesCopy = new ArrayList<String>(values);
		List<String> randomvalues = new ArrayList<String>();

		Random rand = new Random();
		for (int j = 0; j < values.size(); j++) {
			int randomIndex = rand.nextInt(valuesCopy.size());
			randomvalues.add(valuesCopy.get(randomIndex));
			valuesCopy.remove(randomIndex);
		}

		return randomvalues;
	}

	private List<Card> creatCards() {

		List<Card> cards = new ArrayList<Card>();
		for (String color : colors) {
			for (String value : values) {
				cards.add(new Card(color, value));
			}
		}

		return cards;
	}



}
