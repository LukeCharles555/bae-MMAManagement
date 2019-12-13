package com.bae.persistance.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MANAGER")
public class Manager {

	@Id
	@GeneratedValue
	private Long managerID;
	
	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	private Set<Fighters> fighters;
	
	private String username;
	private String password;
	
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
	
	public Set<Fighters> getFighters() {
		return fighters;
	}
	
	public void setFighters(Set<Fighters> fighters) {
		this.fighters = fighters;
	}
	
	@Override
	public String toString() {
		return "Manager [managerID=" + managerID + ", fighters=" + fighters + ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
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
