package com.example.tassi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		List<Record> records = new LinkedList<Record>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("SSL_drm_xp_sens_tassi_MCCY.csv");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        boolean first = true;
        
        Supplier<Map<String, Double>> mapExchangeRates = Main::getExchangeRates;
        
        Consumer<Record> applyDiscount = record -> {
        	switch(record.getDiscountSrc()) {
        		case "payoff":
        			record.setDv01Par(record.getDv01Par() * 0.1);
        			break;
        		case "spot conversion past cash":
        			record.setDv01Par(record.getDv01Par() * 2.0);
        			break;
        		case "spot conversion mv":
        			record.setDv01Par(record.getDv01Par() / (record.getRefDate().until(record.getMaturity(), ChronoUnit.DAYS)));
        			break;
        			
        	}
        };
        
        Consumer<Record> applyTax = record -> {
        	Map<String, Double> mapTax = mapExchangeRates.get();
        	Double exchange = mapTax.getOrDefault(record.getCurrency(), 1.0);
        	record.setDv01Par(record.getDv01Par() * exchange);
        	applyDiscount.accept(record);
        };
        
       
        

        try (BufferedReader br = new BufferedReader(streamReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");   
                if (first == true) {
                	first = false;
                } else {
                    Record record = new Record(LocalDate.parse(values[0],formatter),LocalDate.parse(values[8],formatter),LocalDate.parse(values[9],formatter),Double.parseDouble(values[10]),values[11],Double.parseDouble(values[12]),Double.parseDouble(values[14]),values[15]);
                    
                    records.add(record);
                }
                }
                       
            
            records.forEach(applyTax);
            
            int i = 0;
            for (Record record : records) {          	
				System.out.println(i + " " + record.toString());
				i++;
			}
            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	private static Map<String, Double> getExchangeRates() {
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("EUR", 1.0);
        exchangeRates.put("CNY", 7.5);
        exchangeRates.put("USD", 1.2);
        exchangeRates.put("CZK", 26.0);
        exchangeRates.put("GBP", 0.85);
        exchangeRates.put("AUD", 1.6);
        exchangeRates.put("CAD", 1.5);
        exchangeRates.put("CHF", 1.1);
        exchangeRates.put("HUF", 360.0);
        exchangeRates.put("PLN", 4.5);
        exchangeRates.put("JPY", 130.0);
        exchangeRates.put("KRW", 1400.0);
        exchangeRates.put("NOK", 10.0);
        exchangeRates.put("ZAR", 15.0);
        exchangeRates.put("SEK", 10.5);
        exchangeRates.put("NZD", 1.8);
        exchangeRates.put("RON", 5.0);
        exchangeRates.put("TRY", 9.0);
        exchangeRates.put("COP", 4500.0);
        exchangeRates.put("INR", 90.0);
        exchangeRates.put("BRL", 6.0);
        exchangeRates.put("AED", 4.4);
        return exchangeRates;
    }

}
