package com.example.writefile;

public class Vettura {
	private String targa;
	private String nominativo;
	private Marca marca;
	
	public Vettura(String targa, String nominativo, Marca marca) {
		this.targa = targa;
		this.nominativo = nominativo;
		this.marca = marca;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return targa + "|" + marca + "|" + nominativo ;
	}
	
	
	
}
