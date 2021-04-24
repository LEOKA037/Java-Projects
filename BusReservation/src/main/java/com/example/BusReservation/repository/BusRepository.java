package com.example.BusReservation.repository;

import org.springframework.stereotype.Repository;
import com.example.BusReservation.model.Bus;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long>{
	
	@Query("SELECT b FROM Bus b WHERE b.departureDate = ?1 "
			+ "and b.sourceCity = ?2 "
			+ "and b.destinationCity = ?3"
			)
	List<Bus> findBySearchParameters(Date departureDate,
			String sourceCity,
			String destinationCity
			);
	
	Bus findByBusName(String busName);
}
