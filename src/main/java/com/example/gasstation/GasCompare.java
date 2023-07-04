package com.example.gasstation;

public class GasCompare {

	public static void main(String[] args) {
		GasStation gasStation1 = new GasStation("Gotham City", "Milo Cotogno", 200.0, 50.0);
        GasStation gasStation2 = new GasStation("Marte", "Gabibbo", 300.0, 150.0);

        int comparisonResult = gasStation1.compareTo(gasStation2);

        if (comparisonResult < 0) {
            System.out.println("La stazione di benzina con la capacità più piccola è quella di " + gasStation1.getOwner() + " a " + gasStation1.getCity());
        } else if (comparisonResult > 0) {
            System.out.println("La stazione di benzina con la capacità più piccola è quella di " + gasStation2.getOwner() + " a " + gasStation2.getCity());
        } else {
            System.out.println("Le due stazioni di benzina hanno la stessa capacità");
        }

	}

}
