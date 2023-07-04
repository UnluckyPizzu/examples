package com.example.fibonacci;

import java.util.Scanner;

public class FibonacciRecursive {
	
	/*
	 Sequenza di Fibonacci :
	1,1,2,3,5,6,13,21,34,55,89,144,233,...
	
	La serie di Fibonacci ha una definizione ricorsiva definita come segue
	- Input n = 1 then risultato = 1
	- Input n = 2 then risultato = 1
	- Input n = Intero >= 3 then risultato = Funzione fibonacci Fn-1 + Fn-2
	
	Implementare un progetto che, tramite ricorsività e un numero in input definito dall'utente da console (utilizzare lo Scanner), stampi la relativa serie di Fibonacci.

	 */

	public static void main(String[] args) {
			
			Boolean isInputInt = false;
			int number = 0;
			Scanner scanner = new Scanner(System.in);
			
			while (!isInputInt) {
	            System.out.print("Inserisci il  numero di elementi: ");
	
	            if (scanner.hasNextInt()) {
	            	number = scanner.nextInt();
	                isInputInt = true;
	            } else {
	                System.out.println("Input non valido.");
	                scanner.next();
	            }
	        }
			
			scanner.close();
			
			System.out.println("La serie di Fibonacci lunga " + number + " numeri è:");
			for (int i = 1; i <= number; i++) {
				System.out.print(FibonacciRecursiveFunc(i) + " ");
			}
			
		}
		
		public static int FibonacciRecursiveFunc(int number) {
			
			if (number == 1 || number == 2)
				return 1; 
			else {
				return FibonacciRecursiveFunc(number-1) + FibonacciRecursiveFunc(number-2);
			}
		}

}
