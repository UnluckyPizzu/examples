package com.example.gallery;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
	private String name;
	private List<Artwork> listArtworks;
	
	
	public Gallery(String name) {
		this.name = name;
		listArtworks = new ArrayList<Artwork>();
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Artwork> getListArtworks() {
		return listArtworks;
	}
	
	
	public void addArtwork(Artwork artwork) {
		listArtworks.add(artwork);
	}
	
	public void removeArtwork(Artwork artwork) {
		listArtworks.remove(artwork);
	}
	
	public void printGallery() {
		if (listArtworks.isEmpty()) {
			System.out.println("La galleria è vuota");
		} else {
			System.out.println("La galleria presenta queste opere:");
			for (Artwork artwork : listArtworks) {
				System.out.println(artwork.title);
			}
		}
	}
	
	public void printIngombroArtwork(String titolo) {
        for (Artwork artwork : listArtworks) {
            if (artwork.title.equals(titolo)) {
                double ingombro = artwork.PrintIngombro();
                System.out.println("Ingombro dell'opera '" + artwork.title + "': " + ingombro);
                return;
            }
        }
        System.out.println("Opera '" + titolo + "' non trovata nella collezione.");
    }
}
