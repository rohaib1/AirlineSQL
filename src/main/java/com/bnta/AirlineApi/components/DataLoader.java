package com.bnta.AirlineApi.components;

import com.bnta.AirlineApi.AirlineApiApplication;
import com.bnta.AirlineApi.models.Flight;
import com.bnta.AirlineApi.models.Passenger;
import com.bnta.AirlineApi.repositories.FlightRepository;
import com.bnta.AirlineApi.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public
class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public
    DataLoader(){


    }

    @Override
    public
    void run(ApplicationArguments args) throws Exception{

        Flight flight1 = new Flight("London",300,"4th July","0800");
        Flight flight2 = new Flight("Paris",250,"5th July","0900");

        flightRepository.saveAll(Arrays.asList(
                flight1,
                flight2
        ));

        Passenger passenger1 = new Passenger("Rohaib","07655566666","rohaib@gmail.com");
        Passenger passenger2 = new Passenger("Steve","07655566655","steve@gmail.com");

        passengerRepository.saveAll(Arrays.asList(
                passenger1.addFlight(flight1),
                passenger2.addFlight(flight2)
        ;
    }


