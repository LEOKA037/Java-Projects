package com.example.BusReservation.model;

import java.util.Date;

public class Invoice {

	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	
	private String busName;
	private String operator;
	private Date departureDate;
	private String sourceCity;
	private String destinationCity;
	private Integer duration;
	private Integer price;
	private String userName;
	private String email;
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
