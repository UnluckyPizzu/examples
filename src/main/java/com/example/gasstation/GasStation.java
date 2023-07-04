package com.example.gasstation;

public class GasStation implements Comparable<GasStation>{

	private String _city;
	private String _owner;
	private Double _capacity;
	private Double _containedGas;
	
	public GasStation(String city, String owner, double capacity, double containedGas) {
		this._city = city;
		this._owner = owner;
		this._capacity = capacity;
		this._containedGas = containedGas;
	}
	
	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		this._city = city;
	}

	public String getOwner() {
		return _owner;
	}

	public void setOwner(String owner) {
		this._owner = owner;
	}

	public double getCapacity() {
		return _capacity;
	}

	public void setCapacity(double capacity) {
		this._capacity = capacity;
	}

	public double getContainedGas() {
		return _containedGas;
	}

	public void setContainedGas(double containedGas) {
		this._containedGas = containedGas;
	}

	@Override
	public int compareTo(GasStation otherGasStation) {
		return this._capacity.compareTo(otherGasStation.getCapacity());
	}
	
}
