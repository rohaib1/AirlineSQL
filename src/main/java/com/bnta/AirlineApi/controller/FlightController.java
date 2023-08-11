package com.bnta.AirlineApi.controller;

import com.bnta.AirlineApi.models.Flight;
import com.bnta.AirlineApi.models.PassengerDTO;
import com.bnta.AirlineApi.repositories.FlightRepository;
import com.bnta.AirlineApi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights")
public
class FlightController {

    @Autowired
    FlightService flightService;

    //    INDEX
    @GetMapping
    public
    ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity(flightService.displayAllFLights(), HttpStatus.OK);
    }

    //Specific flight

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Flight>> getFlightsById(Long id){
        return new ResponseEntity(flightService.displaySpecificFlights(id), HttpStatus.OK);
    }


    //Delete flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}