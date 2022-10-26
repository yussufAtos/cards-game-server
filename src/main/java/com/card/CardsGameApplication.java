package com.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.card.service.impl.CardServiceImpl;

@SpringBootApplication
public class CardsGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsGameApplication.class, args);
		
		CardServiceImpl CardServiceImpl =new CardServiceImpl();
		CardServiceImpl.creatSortedHandByColorAndValue();
	}

}