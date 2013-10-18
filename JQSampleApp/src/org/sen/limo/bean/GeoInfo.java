package org.sen.limo.bean;

import java.io.Serializable;

public class GeoInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String city;
	private String lati;
	private String longt;
	private String prio;
	
	public GeoInfo() {
	
	}

	public GeoInfo(String city,String lati,String longt,String prio) {
		this.city=city;
		this.lati=lati;
		this.longt=longt;
		this.prio=prio;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLati() {
		return lati;
	}

	public void setLati(String lati) {
		this.lati = lati;
	}

	public String getLongt() {
		return longt;
	}

	public void setLongt(String longt) {
		this.longt = longt;
	}

	public String getPrio() {
		return prio;
	}

	public void setPrio(String prio) {
		this.prio = prio;
	}
}
