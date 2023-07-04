package com.example.casinoroller;

import java.util.Random;

public class NFacedDice extends AbstractRoller{
	
	private int _faces = 6;
	private Random _random;
	
	public NFacedDice(int faces) {
		this._faces = faces;
	}



	@Override
	String LetsRooooool() {
		_random = new Random();
		int numRolled =_random.nextInt(_faces) + 1;
		return "Il dado è tratto! Hai fatto " + numRolled + "!";
	}

}
