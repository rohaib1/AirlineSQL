package com.bnta.AirlineApi.services;

import com.bnta.AirlineApi.models.Flight;
import com.bnta.AirlineApi.repositories.FlightRepository;
import com.bnta.AirlineApi.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class FlightService {

    //Add details of a new flight
    //Display all available flights
    //Display details of a specific flight

    @Autowired
    FlightRepository flightRepository;

    public void newFlight(Flight flight){
        flightRepository.save(flight);
    }

    public Flight displaySpecificFlights(Long id){
        return flightRepository.findById(id).get();
    }

    public List<Flight> displayAllFLights(){
        return flightRepository.findAll();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }










}
