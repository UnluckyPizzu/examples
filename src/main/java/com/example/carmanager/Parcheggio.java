package com.example.carmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.xml.bind.PrintConversionEvent;

import com.example.writefile.Vettura;

public class Parcheggio {
	private String name;
	private String indirizzo;
	private int maxSize;
	private Double costo;
	List<Vettura> listVetture;
	
	
	public Parcheggio(String name, String indirizzo, int maxSize, Double costo) {
		super();
		this.name = name;
		this.indirizzo = indirizzo;
		this.maxSize = maxSize;
		this.costo = costo;
		listVetture = new ArrayList<Vettura>();
	}
	
	public Double getCosto() {
		return costo;
	}



	public void setCosto(Double costo) {
		this.costo = costo;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public int getPostiOccupati() {
		return listVetture.size();
	}
	
	public int getPostiLiberi() {
		return maxSize - getPostiOccupati();
	}
	
	public boolean isFree() {
		return getPostiLiberi() > 0;
	}
	
	public boolean addVettura(Vettura vettura) {
		if(isFree()) {
			listVetture.add(vettura);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isVetturaInParcheggio(String targa) {
		Boolean isFound = false;
		for (Vettura vettura : listVetture) {
			if(vettura.getTarga().equals(targa)) {
				isFound = true;
			}
		}
		
		return isFound;
	}
	
	public void freeParkedVettura(String targa) {
		listVetture.removeIf(auto -> auto.getTarga().equals(targa));
	}
	
	public double getPayment() {
		return costo * getPostiOccupati();
	}

	@Override
	public String toString() {
		return "Parcheggio [name=" + name + ", indirizzo=" + indirizzo + ", maxSize=" + maxSize + "]";
	}
	
	
	
	
}
