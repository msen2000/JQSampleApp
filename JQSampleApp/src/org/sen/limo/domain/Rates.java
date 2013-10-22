package org.sen.limo.domain;

import java.io.Serializable;

public class Rates implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String fromCity;
	public String toCity;
	public String amount;
	
	public Rates() {
		
	}
	
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
