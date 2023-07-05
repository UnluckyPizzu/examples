package com.example.binarystackqueue;

import java.util.List;
import java.util.Scanner;

public class BinaryConverter {

	/*
	 	Esercizio
			- Realizza un programma che ricevuto in ingresso un numero del sistema numerico decimale lo trasformi in binario, rappresentandone la forma in complemento a uno e in complemento a due .
			- Realizza una pila (di lunghezza indefinita) tramite l'utilizzo della classe ArrayList .
			- Realizzare una coda con priorità tramite la classe ArrayList .
	 */
	
	public static void main(String[] args) {
		Boolean isInputInt = false;
		int input = 0;
		
		Scanner scanner = new Scanner(System.in);
        
        
        while (!isInputInt) {
            System.out.print("Inserisci il numero intero da convertire: ");

            if (scanner.hasNextInt()) {
            	input = scanner.nextInt();
                isInputInt = true;
            } else {
                System.out.println("Input non valido.");
                scanner.next();
            }
        }
        
        scanner.close();
        
        
        String binaryString = convertBinaryFromDecimal(input);
        
        String binaryComplemented = complementToOne(binaryString);
        
        complementToTwo(binaryComplemented);


	}
	
	public static String convertBinaryFromDecimal(int decimal) {
		String binaryString = "";
		int i = 0;
		
		if (decimal == 0) {
			binaryString = "0";
			i++;
		} else {
			while (decimal > 0) {
				binaryString = (decimal % 2) + binaryString;
				decimal = decimal / 2;
				i++;
			}
		}
		
		System.out.println(binaryString);

		
		return binaryString;
	}
	
	public static String complementToOne(String binary) {
		String binaryComplementedString = "";
		int i = 0;
		
		
		while (i < binary.length()) {
			if(binary.charAt(i) == '0') {
				binaryComplementedString = binaryComplementedString + 1;
			} else {
				binaryComplementedString = binaryComplementedString + 0;
			}
			i++;
		}
		
		
		System.out.println(binaryComplementedString);

		
		return binaryComplementedString;
	}
	
	public static String complementToTwo(String binaryComplemented) {
		String binaryComplementedString = "";
		int i = binaryComplemented.length() - 1;
		Boolean riporto = false;
		
		if(binaryComplemented.charAt(i) == '0') {
			binaryComplementedString = binaryComplementedString + 1;
			riporto = false;
		} else {
			binaryComplementedString = binaryComplementedString + 0;
			riporto = true;
		}
		i--;
		
		
		while (i >= 0) {
			if(binaryComplemented.charAt(i) == '0') {
				if(riporto == false) {
					binaryComplementedString = 0 + binaryComplementedString;
					riporto = false;
				} else {
					binaryComplementedString = 1 + binaryComplementedString;
					riporto = false;
				}
			} else {
				if(riporto == true) {
					binaryComplementedString = 0 + binaryComplementedString;
					riporto = true;
				} else {
					binaryComplementedString = 1 + binaryComplementedString;
					riporto = false;
				}
			}
			i--;
		}
		
		
		System.out.println(binaryComplementedString);

		
		return binaryComplementedString;
	}

}
