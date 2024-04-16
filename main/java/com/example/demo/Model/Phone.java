package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String number;


  @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER) 
  @JoinColumn(name = "persons_id", nullable = false)
  private Person persons;


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
//public Person getPersons() {
//	return persons;
//}
public void setPersons(Person persons) {
	this.persons = persons;
}


}
