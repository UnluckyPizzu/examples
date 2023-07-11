package com.example.carmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import com.example.writefile.Vettura;

public class ParcheggioManager {
	List<Parcheggio> listParcheggio;
	List<Vettura> notParkedVetture;
	
	public ParcheggioManager() {
		listParcheggio = new ArrayList<Parcheggio>();
        listParcheggio.add(new Parcheggio("ParkFree", "Via Brambilla", 5, 0.0));
        listParcheggio.add(new Parcheggio("ParkPay", "Via Ciruzzo", 10, 5.5));
        listParcheggio.add(new Parcheggio("LuxuryPark", "Via Gianni", 1000, 16.75));
        notParkedVetture = new ArrayList<Vettura>();
	}
	
	
	public void addVetture(List<Vettura> listVettura) {
		Collections.shuffle(listVettura);
		for (int i = 0; i < 20; i++) {
			if (!isVeicoloCointained(listVettura.get(i))) {
				Random random = new Random();
				int newRand = random.nextInt(3);
				if (listParcheggio.get(newRand).isFree()) {
					listParcheggio.get(newRand).addVettura(listVettura.get(i));
				} else {
					notParkedVetture.add(listVettura.get(i));
					System.out.println(listVettura.get(i).getTarga() + " ha trovato occupato");
				}
			}
		}
		
		for (int i = 20; i < listVettura.size(); i++) {
			if (!isVeicoloCointained(listVettura.get(i))) {
				if (listParcheggio.get(0).isFree()) {
					listParcheggio.get(0).addVettura(listVettura.get(i));
				} else if (listParcheggio.get(1).isFree()) {
					listParcheggio.get(1).addVettura(listVettura.get(i));
				} else if (listParcheggio.get(2).isFree()) {
					listParcheggio.get(2).addVettura(listVettura.get(i));
				} else {
					notParkedVetture.add(listVettura.get(i));
				}
			}
		}
	}
	
	public boolean isVeicoloCointained(Vettura veicolo) {
		Boolean isFound = false;
		for (Parcheggio parcheggio : listParcheggio) {
			if (parcheggio.isVetturaInParcheggio(veicolo.getTarga()))
				isFound = true;
		}
		
		return isFound;
	}
	
	public int countNotParkedVetture() {
		return notParkedVetture.size();
	}
	
	public void printInfoParcheggio(String nameParcheggio) {
		Consumer<Parcheggio> printParcheggio = parcheggio -> {
			System.out.println("Dati del parcheggio " + nameParcheggio + ":");
			System.out.println("Stampa vetture:");
			for (Vettura vettura : parcheggio.listVetture) {
				System.out.println(vettura.toString());
			}
			System.out.println("Numero massimo: " + parcheggio.getMaxSize() + "; Numero posti occupati:" + parcheggio.getPostiOccupati() + ";");
		};
		listParcheggio.stream().filter(parcheggio -> parcheggio.getName().equals(nameParcheggio)).forEach(printParcheggio);
	}
	
	public void findVeicolo(String targa) {
		boolean isFound = false;
		for (Parcheggio parcheggio : listParcheggio) {
			if(parcheggio.isVetturaInParcheggio(targa)) {
				isFound = true;
				System.out.println("Veicolo presente nel parcheggio " + parcheggio.getName());			}
		}
		
		if (!isFound) {
			for (Vettura vettura : notParkedVetture) {
				if (vettura.getTarga().equals(targa)) {
					isFound = true;
					System.out.println("Veicolo presente ma non parcheggiato");
				}
			}
		}
		
		if(!isFound) {
			System.out.println("Veicolo non presente in gestionale");
		}
		
		
	}
	
	
}
