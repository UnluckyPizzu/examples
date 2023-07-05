package com.example.writefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	private static final String[] NOMI_PROPRIETARI = {
            "Mario Rossi",
            "Luca Bianchi",
            "Giovanni Verdi",
            "Paolo Neri",
            "Giuseppe Russo",
            "Antonio Esposito",
            "Roberto Romano",
            "Francesco Ricci",
            "Riccardo Gallo",
            "Davide Greco",
            "Simone Marino",
            "Federico Bruno",
            "Giorgio Costa",
            "Alberto Conti",
            "Stefano Fiore",
            "Vincenzo De Luca",
            "Michele Gentile",
            "Lorenzo Serra",
            "Alessandro Rizzo",
            "Andrea D'Amico",
            "Fabio Russo",
            "Enrico Lombardo",
            "Pietro Moretti",
            "Claudio Giuliani",
            "Salvatore Santoro",
            "Marco Palumbo",
            "Filippo Sorrentino",
            "Maurizio De Santis",
            "Emilio Caruso",
            "Nicola Gallo"
    };

    private static final Random random = new Random();
	
	public static void main(String[] args) {
		String filePath = "vetture.txt";

        deleteFile(filePath);

        List<Vettura> vetture = new ArrayList<>();
        try {
            for (int i = 0; i < 30; i++) {
                Vettura vettura = createRandomVettura(vetture);
                vetture.add(vettura);
            }
            writeToFile(filePath, vetture);
            System.out.println("File \"" + filePath + "\" creato con successo.");
        } catch (VehicleDuplicationException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Vettura createRandomVettura(List<Vettura> vetture) throws VehicleDuplicationException {
        String targa = generateRandomTarga();
        Marca marca = getRandomMarca();
        String nomeProprietario = getRandomNomeProprietario();

        for (Vettura vettura : vetture) {
            if (vettura.getTarga().equals(targa)) {
                throw new VehicleDuplicationException("Targa duplicata: " + targa);
            }
        }

        return new Vettura(targa, nomeProprietario, marca);
    }

    private static String generateRandomTarga() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateRandomUpperCaseChar()).append(generateRandomUpperCaseChar());
        sb.append(generateRandomDigit()).append(generateRandomDigit());
        sb.append(generateRandomUpperCaseChar()).append(generateRandomUpperCaseChar());
        return sb.toString();
    }

    private static char generateRandomUpperCaseChar() {
        return (char) (random.nextInt(26) + 'A');
    }

    private static int generateRandomDigit() {
        return random.nextInt(10);
    }

    private static Marca getRandomMarca() {
        int randomIndex = random.nextInt(6);
        return Marca.values()[randomIndex];
    }

    private static String getRandomNomeProprietario() {
        int randomIndex = random.nextInt(NOMI_PROPRIETARI.length);
        return NOMI_PROPRIETARI[randomIndex];
    }

    private static void writeToFile(String filePath, List<Vettura> vetture) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Vettura vettura : vetture) {               
                writer.write(vettura.toString());
                writer.newLine();
            }
        }
        
    }

    private static void deleteFile(String filePath) {
        try {
            boolean success = Files.deleteIfExists(Paths.get(filePath));
            if (success) {
                System.out.println("File precedente \"" + filePath + "\" cancellato.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
