package com.bnta.AirlineApi.repositories;

import com.bnta.AirlineApi.models.Flight;
import com.bnta.AirlineApi.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface FlightRepository extends JpaRepository<Flight, Long> {

}
