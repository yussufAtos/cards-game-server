package com.card.controller;

import org.springframework.web.bind.annotation.RestController;
import com.card.service.CardService;

@RestController
public class CardController {

	private final CardService CardService;

	public CardController(CardService CardService) {
		this.CardService = CardService;
	}
}
