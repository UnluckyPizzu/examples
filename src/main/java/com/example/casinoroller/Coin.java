package com.example.casinoroller;

import java.util.Random;

public class Coin extends AbstractRoller {

	@Override
	String LetsRooooool() {
		Random random = new Random();
		Boolean coinFlip = random.nextBoolean();
		if (coinFlip)
			return "Il lancio della moneta rivela che è uscito testa!";
		else {
			return "Il lancio della moneta rivela che è uscito croce!";
		}
	}

}
