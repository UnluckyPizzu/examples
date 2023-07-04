package com.example.primenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {
	
	// Calcola i numeri primi compresi tra due numeri interi inseriti dall'utente. 

	public static void main(String[] args) {
		Boolean isInputInt = false;
		int firstNumber = 0;
		int secondNumber = 0;
		
		Predicate<Integer> primeNumberPredicate = primeNumbers -> {
			if (primeNumbers <= 1) {
	            return false;
	        }
			
			for (int i = 2; i < primeNumbers; i++) {
	            if (primeNumbers % i == 0) {
	                return false;
	            }
	        }
			
			return true;
		};
		
		IntPredicate primeNumberIntPredicate = number -> primeNumberPredicate.test(number);
		
		Scanner scanner = new Scanner(System.in);
        
        
        while (!isInputInt) {
            System.out.print("Inserisci il primo numero intero: ");

            if (scanner.hasNextInt()) {
            	firstNumber = scanner.nextInt();
                isInputInt = true;
            } else {
                System.out.println("Input non valido.");
                scanner.next();
            }
        }
        
        isInputInt = false;
        
        
        while (!isInputInt) {
            System.out.print("Inserisci il secondo numero intero: ");

            if (scanner.hasNextInt()) {
            	secondNumber = scanner.nextInt();
                isInputInt = true;
            } else {
                System.out.println("Input non valido.");
                scanner.next();
            }
        }
        
        scanner.close();
		
        
        System.out.println("I numeri primi tra " + firstNumber + " e " + secondNumber + " sono:");
        IntStream.rangeClosed(firstNumber, secondNumber).filter(primeNumberIntPredicate).forEach(System.out::println);
		
	}

}
