package com.example.gallery;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

public class Main {

	public static void main(String[] args) {
		Gallery gallery = new Gallery("Galleria delle carte da collezione");

        Artwork pikachu = new Painting("Pikachu", "Nintendo", 100.0, 80.0);
        Artwork idk = new Painting("Mai giocato a questo gioco", "Magic", 120.0, 90.0);
        Artwork drago  = new Sculpture("Drago Bianco occhi blu", "Yu-Gi-Oh!", 200.0, 150.0, 80.0);

        gallery.addArtwork(pikachu);
        gallery.addArtwork(idk);
        gallery.addArtwork(drago);

        gallery.printGallery();

        gallery.printIngombroArtwork("Pikachu");
        gallery.printIngombroArtwork("Drago Bianco occhi blu");
        gallery.printIngombroArtwork("Mago Nero");
        
        System.out.println(pikachu.equals(idk));
        System.out.println(idk.equals(new Painting("Mai giocato a questo gioco", "Magic", 30.0, 20.0)));
        System.out.println(idk.equals(new Sculpture("Mai giocato a questo gioco", "Magic", 30.0, 20.0, 10.00)));
        System.out.println(idk.equals(null));

	}

}
