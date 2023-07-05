package com.example.readingfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("dizionario.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

        try (BufferedReader br = new BufferedReader(streamReader)) {
            String parola;
            while ((parola = br.readLine()) != null) {
                hashSet.add(parola);
                treeSet.add(parola);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String wordToFind = "apple";

        long startTimeHashSet = System.nanoTime();
        boolean trovatoHashSet = hashSet.contains(wordToFind);
        long endTimeHashSet = System.nanoTime();
        long elapsedTimeHashSet = endTimeHashSet - startTimeHashSet;

        long startTimeTreeSet = System.nanoTime();
        boolean trovatoTreeSet = treeSet.contains(wordToFind);
        long endTimeTreeSet = System.nanoTime();
        long elapsedTimeTreeSet = endTimeTreeSet - startTimeTreeSet;

        System.out.println("Risultati del test di recupero della parola \"" + wordToFind + "\":");
        System.out.println("HashSet: Trovato = " + trovatoHashSet + ", Tempo impiegato = " + elapsedTimeHashSet + " ns");
        System.out.println("TreeSet: Trovato = " + trovatoTreeSet + ", Tempo impiegato = " + elapsedTimeTreeSet + " ns");

        if (elapsedTimeHashSet < elapsedTimeTreeSet) {
            System.out.println("La ricerca nella HashSet è più veloce.");
        } else if (elapsedTimeTreeSet < elapsedTimeHashSet) {
            System.out.println("La ricerca nella TreeSet è più veloce.");
        } else {
            System.out.println("I tempi di ricerca nella HashSet e nella TreeSet sono simili.");
        }
        
        
        
        
        wordToFind = "grapefruit";

        startTimeHashSet = System.nanoTime();
        trovatoHashSet = hashSet.contains(wordToFind);
        endTimeHashSet = System.nanoTime();
        elapsedTimeHashSet = endTimeHashSet - startTimeHashSet;

        startTimeTreeSet = System.nanoTime();
        trovatoTreeSet = treeSet.contains(wordToFind);
        endTimeTreeSet = System.nanoTime();
        elapsedTimeTreeSet = endTimeTreeSet - startTimeTreeSet;

        System.out.println("\nRisultati del test di recupero della parola \"" + wordToFind + "\":");
        System.out.println("HashSet: Trovato = " + trovatoHashSet + ", Tempo impiegato = " + elapsedTimeHashSet + " ns");
        System.out.println("TreeSet: Trovato = " + trovatoTreeSet + ", Tempo impiegato = " + elapsedTimeTreeSet + " ns");

        if (elapsedTimeHashSet < elapsedTimeTreeSet) {
            System.out.println("La ricerca nella HashSet è più veloce.");
        } else if (elapsedTimeTreeSet < elapsedTimeHashSet) {
            System.out.println("La ricerca nella TreeSet è più veloce.");
        } else {
            System.out.println("I tempi di ricerca nella HashSet e nella TreeSet sono simili.");
        }
    }
}

