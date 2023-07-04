package com.example.Operation;

public abstract class BasicOperation implements Operation {

	@Override
	public void DoOperationAndPrint(double firstNumber, double secondNumber) {
		System.out.println("Il risultato dell'operazione è " + DoOperation(firstNumber, secondNumber));
	}

}
