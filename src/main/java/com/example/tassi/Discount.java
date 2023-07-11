package com.example.tassi;

import java.time.temporal.ChronoUnit;

public enum Discount {
	
	
	PAYOFF("payoff") {

		@Override
		void applyDiscount(Record record) {
			record.setDv01Par(record.getDv01Par() * 0.1);
		}
		
	},
	PAST_CASH("spot conversion past cash") {
		@Override
		void applyDiscount(Record record) {
			record.setDv01Par(record.getDv01Par() * 2.0);
		}
	},
	MV("spot conversion mv") {
		@Override
		void applyDiscount(Record record) {
			record.setDv01Par(record.getDv01Par() / (record.getRefDate().until(record.getMaturity(), ChronoUnit.DAYS)));
		}
	};
	
	private final String discountName;
	

	private Discount(String name) {
		this.discountName = name;
	}

	public String getDiscountName() {
		return discountName;
	}
	
	public static Discount fromString(String text) {
        for (Discount discount : Discount.values()) {
            if (discount.discountName.equalsIgnoreCase(text)) {
                return discount;
            }
        }
        return null;
    }
	
	abstract void applyDiscount(Record record);

}
