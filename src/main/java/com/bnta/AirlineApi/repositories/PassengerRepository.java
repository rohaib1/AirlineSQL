package com.bnta.AirlineApi.repositories;

import com.bnta.AirlineApi.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
