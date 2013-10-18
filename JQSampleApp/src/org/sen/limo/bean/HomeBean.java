package org.sen.limo.bean;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="homeBean")
@SessionScoped
public class HomeBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;	
	private List<Person> persons = new ArrayList<Person>();
	private List<GeoInfo> geos = new ArrayList<GeoInfo>();
	private int geoslength=4;
	private String address;
			
	public HomeBean() {
		persons = new ArrayList<Person>(); 
		persons.add(new Person("Sen1","3803 Darwin Dr", "msen2001@gmail.com","510-386-9673", "Pending1"));
		persons.add(new Person("Sen2","3803 Darwin Dr", "msen2002@gmail.com","510-386-9673", "Pending1"));
		persons.add(new Person("Sen3","3803 Darwin Dr", "msen2003@gmail.com","510-386-9673", "Pending1"));
		persons.add(new Person("Sen","3803 Darwin Dr", "msen2000@gmail.com","510-386-9673", "Pending"));
		
		geos = new ArrayList<GeoInfo>();
		geos.add(new GeoInfo("Sunnyvale", "37.368830000000000000", "-122.036349600000000000", "5"));
		geos.add(new GeoInfo("San Jose", "37.339385700000000000", "-121.894955499999980000", "1"));
		geos.add(new GeoInfo("Hayward", "37.6688205", "-122.0807964", "2"));
		geos.add(new GeoInfo("Oakland", "37.804363700000000000", "-122.271113700000000000", "3"));
		geos.add(new GeoInfo("Fremont", "37.5482697", "-121.98857190000001", "4"));
		
		geoslength=4;		
		
		address = "3803 Darwin Dr, Fremont, CA 94555";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<GeoInfo> getGeos() {
		return geos;
	}

	public void setGeos(List<GeoInfo> geos) {
		this.geos = geos;
	}

	public int getGeoslength() {
		return geoslength;
	}

	public void setGeoslength(int geoslength) {
		this.geoslength = geoslength;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
