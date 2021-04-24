package com.example.BusReservation.model;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "BUS_DETAILS")
public class Bus {

	@Id
	@Column(name = "busId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long busId;
	
	@Column(name = "busName", nullable = false)
	private String busName;
	
	@Column(name = "operator", nullable = false)
	private String operator;	
	
	@Column(name = "duration", nullable = false)
	private Integer duration;
	
	@Column(name = "price", nullable = false)
	private Integer price;
	
	@Column(name = "availableSeats", nullable = false)
	private String availableSeats;
	
	@Column(name = "bookedSeats", nullable = false)
	private String bookedSeats;
	
	@Column(name = "sourceCity", nullable = false)
	private String sourceCity;
	
	@Column(name = "destinationCity", nullable = false)
	private String destinationCity;
	
	@Column(name = "departureDate", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureDate;
	
	@Column(name = "arrivalDate", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date arrivalDate;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="BUS_ID")
    private Set<Ticket> tickets;
    
	public Bus() {}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public String getBusName() {
		return busName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(String availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
