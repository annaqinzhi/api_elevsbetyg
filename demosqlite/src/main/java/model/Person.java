package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	String id;
	String firstName;
	String lastName;
	String betyg;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBetyg() {
		return betyg;
	}
	public void setBetyg(String betyg) {
		this.betyg = betyg;
	}
	
	public String toString() {
		return id+";"+firstName+";"+lastName+";"+betyg+"\n";
	}
	
}
