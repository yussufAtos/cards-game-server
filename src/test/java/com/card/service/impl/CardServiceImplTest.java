package com.card.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.card.model.Card;
import com.card.service.CardService;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class CardServiceImplTest {

	@Autowired
	private CardService cardService;
	private static final int HAND_NUMBER = 10;
	private static final List<String> mockRandomColors = List.of("Trèfle", "Pique", "Carreaux", "Coeur");
	private static final List<String> mockRandomvalues = List.of("2", "4", "AS", "5", "6", "8", "3", "9", "7", "Roi",
			"10", "Valet", "Dame");

	// [2, 4, AS, 5, 6, 8, 3, 9, 7, Roi, 10, Valet, Dame]
//should_createRandomHand_return_expected_size_of_hand
//should_creatSortedHandByColorAndValue_return_expected_sorted_cards_by_given_colors_and_values_order

	@Test
	void should_createRandomHand_return_hand_of_10_cards() {
		System.out.println("hello test");

		List<Card> cardsHand = cardService.createRandomHand();
		assertEquals(cardsHand.size(), HAND_NUMBER);

	}

	@Test
	void should_creatSortedHandByColorAndValue_return_expected_sorted_cards_by_given_colors_and_values_order() {

		List<Card> mockHand = new ArrayList<Card>();

		mockHand.add(new Card("Coeur", "9"));
		mockHand.add(new Card("Pique", "6"));
		mockHand.add(new Card("Pique", "9"));

		mockHand.add(new Card("Trèfle", "AS"));
		mockHand.add(new Card("Carreaux", "4"));
		mockHand.add(new Card("Carreaux", "2"));

		mockHand.add(new Card("Coeur", "Dame"));
		mockHand.add(new Card("Carreaux", "Dame"));
		mockHand.add(new Card("Coeur", "AS"));
		mockHand.add(new Card("Coeur", "3"));

		List<Card> expectedSortedHand = new ArrayList<Card>();

		expectedSortedHand.add(new Card("Trèfle", "AS"));
		expectedSortedHand.add(new Card("Pique", "6"));
		expectedSortedHand.add(new Card("Pique", "9"));

		expectedSortedHand.add(new Card("Carreaux", "2"));
		expectedSortedHand.add(new Card("Carreaux", "4"));
		expectedSortedHand.add(new Card("Carreaux", "Dame"));

		expectedSortedHand.add(new Card("Coeur", "AS"));
		expectedSortedHand.add(new Card("Coeur", "3"));
		expectedSortedHand.add(new Card("Coeur", "9"));
		expectedSortedHand.add(new Card("Coeur", "Dame"));

		List<Card> actualSortedHand = cardService.creatSortedHandByColorAndValue(mockRandomColors, mockRandomvalues,
				mockHand);

		System.out.println("expected " + expectedSortedHand);

		assertEquals(expectedSortedHand, actualSortedHand);
	}

}
