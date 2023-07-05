package com.example.tassi;

import java.time.LocalDate;
import java.util.Date;

public class Record {
	private LocalDate refDate;
	private LocalDate startDate;
	private LocalDate maturity;
	private double zeroCpn;
    private String currency;
    private double zeroCpnEUR;
    private double dv01Par;
    private String discountSrc;
    
    
    
	public Record() {
	}

	public Record(LocalDate refDate, LocalDate startDate, LocalDate maturity, double zeroCpn, String currency, double zeroCpnEUR, double dv01Par,
			String discountSrc) {
		super();
		this.refDate = refDate;
		this.startDate = startDate;
		this.maturity = maturity;
		this.zeroCpn = zeroCpn;
		this.currency = currency;
		this.zeroCpnEUR = zeroCpnEUR;
		this.dv01Par = dv01Par;
		this.discountSrc = discountSrc;
	}
	
	public LocalDate getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDate refDate) {
		this.refDate = refDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getMaturity() {
		return maturity;
	}

	public void setMaturity(LocalDate maturity) {
		this.maturity = maturity;
	}

	public double getZeroCpn() {
		return zeroCpn;
	}

	public void setZeroCpn(double zeroCpn) {
		this.zeroCpn = zeroCpn;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getZeroCpnEUR() {
		return zeroCpnEUR;
	}

	public void setZeroCpnEUR(double zeroCpnEUR) {
		this.zeroCpnEUR = zeroCpnEUR;
	}

	public double getDv01Par() {
		return dv01Par;
	}

	public void setDv01Par(double dv01Par) {
		this.dv01Par = dv01Par;
	}

	public String getDiscountSrc() {
		return discountSrc;
	}

	public void setDiscountSrc(String discountSrc) {
		this.discountSrc = discountSrc;
	}

	@Override
	public String toString() {
		return "Record [refDate=" + refDate + ", startDate=" + startDate + ", maturity=" + maturity + ", zeroCpn=" + zeroCpn + ", currency="
				+ currency + ", zeroCpnEUR=" + zeroCpnEUR + ", dv01Par=" + dv01Par + ", discountSrc=" + discountSrc
				+ "]";
	}
	
	
    
}
