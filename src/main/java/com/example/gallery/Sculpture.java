package com.example.gallery;

public class Sculpture extends Artwork {
	private Double length, width, depth;
	
	public Sculpture(String title, String artist, Double length, Double width, Double depth) {
		super(title, artist);
		this.length = length;
		this.width = width;
		this.depth = depth;
	}	

	public Double getLength() {
		return length;
	}



	public void setLength(Double length) {
		this.length = length;
	}



	public Double getWidth() {
		return width;
	}



	public void setWidth(Double width) {
		this.width = width;
	}



	public Double getDepth() {
		return depth;
	}



	public void setDepth(Double depth) {
		this.depth = depth;
	}
	
	@Override
	Double PrintIngombro() {
		return length * width * depth;
	}

}
