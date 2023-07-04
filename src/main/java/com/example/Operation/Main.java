package com.example.Operation;

public class Main {

	public static void main(String[] args) {
		double firstNumber = 10.0;
        double secondNumber = 5.0;

        Operation operazione = new Addition();
        operazione.DoOperationAndPrint(firstNumber, secondNumber);

        operazione = new Subtraction();
        operazione.DoOperationAndPrint(firstNumber, secondNumber);

        operazione = new Multiplication();
        operazione.DoOperationAndPrint(firstNumber, secondNumber);

        operazione = new Division();
        operazione.DoOperationAndPrint(firstNumber, secondNumber);

	}

}
