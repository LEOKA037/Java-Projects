package com.example.BusReservation.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class User {
	
	@Column(name = "email",nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;


	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private Set<Ticket> tickets;


	@Id
	@Column(name = "userId", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "userName", nullable = false, unique = true)
	private String userName;


	public User() {		
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}
	
	public String getUserName() {
		return userName;
	}	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

}
