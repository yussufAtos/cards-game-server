package com.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.card.model.Card;
import com.card.model.CardDto;
import com.card.service.CardService;

@RestController
@CrossOrigin(origins = { "http://localhost:4300" })
public class CardController {

	private final CardService cardService;

	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@GetMapping({ "/hand" })
	public List<Card> getGameHand() {

		return this.cardService.createRandomHand();
	}

	@GetMapping({ "/playCards" })
	public CardDto getPlayedCards() {

		return this.cardService.playCards();
	}

}
