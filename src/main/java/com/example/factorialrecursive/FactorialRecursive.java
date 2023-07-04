package com.example.factorialrecursive;

import java.util.Scanner;

public class FactorialRecursive {
	
	// Scrivere il programma del fattoriale con un metodo ricorsivo.

	public static void main(String[] args) {
		
		Boolean isInputInt = false;
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		
		while (!isInputInt) {
            System.out.print("Inserisci il primo numero intero: ");

            if (scanner.hasNextInt()) {
            	number = scanner.nextInt();
                isInputInt = true;
            } else {
                System.out.println("Input non valido.");
                scanner.next();
            }
        }
		
		scanner.close();
		
		System.out.println("Il fattoriale di " + number + " è " + FactorialRecursiveFunc(number));
		
	}
	
	public static int FactorialRecursiveFunc(int number) {
		
		if (number == 1)
			return 1;
		else {
			return number * FactorialRecursiveFunc(number-1);
		}
	}

}
