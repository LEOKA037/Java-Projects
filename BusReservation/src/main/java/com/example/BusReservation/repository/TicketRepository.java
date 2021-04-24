package com.example.BusReservation.repository;

import org.springframework.stereotype.Repository;
import com.example.BusReservation.model.Ticket;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{

}
