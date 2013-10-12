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
			
	public HomeBean() {
		persons = new ArrayList<Person>(); 
		persons.add(new Person("Sen1","3803 Darwin Dr", "msen2001@gmail.com","510-386-9673", "Pending1"));
		persons.add(new Person("Sen2","3803 Darwin Dr", "msen2002@gmail.com","510-386-9673", "Pending1"));
		persons.add(new Person("Sen3","3803 Darwin Dr", "msen2003@gmail.com","510-386-9673", "Pending1"));
		persons.add(new Person("Sen","3803 Darwin Dr", "msen2000@gmail.com","510-386-9673", "Pending"));
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

}
