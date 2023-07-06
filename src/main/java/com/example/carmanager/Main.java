package com.example.carmanager;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.example.writefile.Marca;
import com.example.writefile.Vettura;

public class Main {

	public static void main(String[] args) {
		ParcheggioManager manager = new ParcheggioManager();
		List<Vettura> listVettura = new ArrayList<Vettura>();
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("vetture.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(streamReader)) {
            String parola;
            while ((parola = br.readLine()) != null) {
                String[] fields = parola.split("\\|");
                listVettura.add(new Vettura(fields[0], fields[2], Marca.valueOf(fields[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("FINE POPOLAZIONE\n\n\n\n");

        manager.addVetture(listVettura);
        manager.listParcheggio.forEach(parcheggio -> manager.printInfoParcheggio(parcheggio.getName()));
	
        manager.findVeicolo("VM36PZ");
        
        
        System.out.println("\n\nPagamento di LuxuryPark: " + manager.listParcheggio.get(2).getPayment());
	}

}
