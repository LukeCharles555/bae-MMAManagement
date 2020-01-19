package com.bae.persistance.domain;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long managerID;
	private String username;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "managerID")
	private List<Fighters> fighters;
	
	public List<Fighters> getFighters() {
		return fighters;
	}

	public void setFighters(List<Fighters> fighters) {
		this.fighters = fighters;
	}

	
	public Manager() {
	}
	
	public Manager(String username) {
		super();
		this.username = username;
	}

	public Long getManagerID() {
		return managerID;
	}
	
	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	

	
}
