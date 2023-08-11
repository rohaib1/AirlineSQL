package com.bnta.AirlineApi.controller;

import com.bnta.AirlineApi.models.Passenger;
import com.bnta.AirlineApi.models.PassengerDTO;
import com.bnta.AirlineApi.repositories.PassengerRepository;
import com.bnta.AirlineApi.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Get passenger
//add passenger

@RestController
@RequestMapping("passengers")
public
class PassengerController {

    @Autowired
    PassengerService passengerService;

    //Get

    @GetMapping
    public
    ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.displayAllPassengerInfo(), HttpStatus.OK);
    }

    //get by id
    @GetMapping(value = "/{id}")
    public
    ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        Passenger foundPassenger = passengerService.displayPassengerInfo(id);
        return new ResponseEntity(foundPassenger, HttpStatus.OK);
    }

    //Create New Passenger
    @PostMapping
    public
    ResponseEntity<List<Passenger>> postPassenger(@RequestBody PassengerDTO passengerDTO){
        passengerService.addPassenger(passengerDTO);
        return new ResponseEntity<>(passengerService.displayAllPassengerInfo(), HttpStatus.CREATED);
    }


    //Delete Passenger
    @DeleteMapping(value = "/{id}")
    public
    ResponseEntity<Long> deletePassenger(@PathVariable Long id){
        passengerService.deletePassenger(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}



