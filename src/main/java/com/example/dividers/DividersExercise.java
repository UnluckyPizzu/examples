package com.example.dividers;

import java.util.Scanner;

public class DividersExercise {
	
	// Scrivere un programma che richiesto un numero intero visualizzi tutti i suoi divisori, contandoli.  

	public static void main(String[] args) {
		
        int dividers = 0;
        Boolean inputInt = false;
        int input = 0;
        
		Scanner scanner = new Scanner(System.in);
        
        
        while (!inputInt) {
            System.out.print("Inserisci un numero intero: ");

            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                inputInt = true;
            } else {
                System.out.println("Input non valido.");
                scanner.next();
            }
        }
        
        scanner.close();

        System.out.println("I divisori di " + input + " sono: ");
        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                System.out.print(i + " ");
                dividers++;
            }
        }

        System.out.print("\n");
        
        System.out.println("Il numero " + input + " ha " + dividers + " divisori.");
	}

}
