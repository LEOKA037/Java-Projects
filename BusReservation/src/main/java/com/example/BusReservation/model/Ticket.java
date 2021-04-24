package com.example.BusReservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TICKET_DETAILS")
public class Ticket {

	@ManyToOne
	@JoinColumn(
	        name = "BUS_ID",
	        referencedColumnName = "busId"
	    )
    private Bus bus;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "reservationDate", nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date reservationDate;

	@Column(name = "seatNumber", nullable = false)
	private String seatNumber;
	
	@Column(name = "ticketNumber", nullable = false)
	private String ticketNumber;
	
	@ManyToOne
	@JoinColumn(
	        name = "USER_ID",
	        referencedColumnName = "userId"
	    )
    private User user;

	public Ticket() {
		
	}

	public Bus getBus() {
		return bus;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public User getUser() {
		return user;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
