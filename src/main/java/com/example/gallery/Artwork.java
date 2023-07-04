package com.example.gallery;

public abstract class Artwork {
	protected String title;
	protected String artist;
	
	public Artwork(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	abstract Double PrintIngombro();

	@Override
	public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Artwork artwork = (Artwork) o;

        if (!title.equals(artwork.title) || !artist.equals(artwork.artist)) return false;
        
        return true;
    }
}
