package com.example.gallery;

public class Painting extends Artwork {

	private Double length, width;
	
	public Painting(String title, String artist, Double length, Double width) {
		super(title, artist);
		this.length = length;
		this.width = width;
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

	@Override
    public Double PrintIngombro() {
        return length * width;
    }

}
