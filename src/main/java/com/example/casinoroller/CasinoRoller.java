package com.example.casinoroller;

import java.util.Scanner;

public class CasinoRoller {

	// Scrivi un programma che simuli il lancio di un dado e di una moneta stampandone il risultato; con e senza l'utilizzo di una classe astratta che rappresenti i comportamenti comuni degli oggetti dado e moneta istanziati.
	
	public static void main(String[] args) {
		/*
		Boolean isInputInt = false;
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (!isInputInt) {
            System.out.print("Inserisci il numero di lati del dado: ");

            if (scanner.hasNextInt()) {
            	number = scanner.nextInt();
                isInputInt = true;
            } else {
                System.out.println("Input non valido.");
                scanner.next();
            }
        }
		
		scanner.close();
		*/
		
		NFacedDice dice = new NFacedDice(6);
		Coin coin = new Coin();
		
		System.out.println(dice.LetsRooooool());
		System.out.println(coin.LetsRooooool());
	}

}
