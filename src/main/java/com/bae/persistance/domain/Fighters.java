package com.bae.persistance.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Fighters {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fighterID;
	private String firstName;
	private String lastName;
	private int height;
	private int weight;
	
	public Fighters() {
	}
	
	public Fighters(String firstName, String lastName, int height, int weight) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
		this.weight = weight;
	}

	public Long getFighterID() {
		return fighterID;
	}
	
	public void setFighterID(Long fighterID) {
		this.fighterID = fighterID;
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
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fighters other = (Fighters) obj;
		if (fighterID == null) {
			if (other.fighterID != null)
				return false;
		} else if (!fighterID.equals(other.fighterID))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (height != other.height)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	

	
	
}
