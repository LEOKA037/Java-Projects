package com.example.BusReservation.repository;

import org.springframework.stereotype.Repository;

import com.example.BusReservation.model.User;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUserName(String userName);

}
