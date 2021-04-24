package com.example.BusReservation.model;

import java.util.Date;

public class Search {

	public Search() {
	}
	String busName;
	Date departureDate;
	Date returnDate;
	String sourceCity;
	String destinationCity;
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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
}
