package com.bnta.AirlineApi.services;

import com.bnta.AirlineApi.models.Flight;
import com.bnta.AirlineApi.models.Passenger;
import com.bnta.AirlineApi.models.PassengerDTO;
import com.bnta.AirlineApi.repositories.FlightRepository;
import com.bnta.AirlineApi.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public
class PassengerService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    //Add new passenger
    //Display details of all passengers
    //Display details of a specific passenger
    //Book a passenger on to a flight

    public Passenger addPassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getPhoneNumber(), passengerDTO.getEmailAddress());

        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);


    }


    //Delete passenger
    public void deletePassenger(Long id){
        passengerRepository.deleteById(id);
    }


    public Passenger displayPassengerInfo(Long id){
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> displayAllPassengerInfo(){
        return passengerRepository.findAll();
    }

    public Passenger bookPassenger(Passenger passenger){
        passengerRepository.save(passenger);
                return passenger;
    }


}
