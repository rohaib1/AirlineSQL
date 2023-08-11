package com.bnta.AirlineApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private String emailAddress;

    @ManyToMany
    @JsonIgnoreProperties("passengers")
    @JoinTable(
            name = "passenger_flight",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private List<Flight> flights;


    public
    Passenger(String name, String phoneNumber, String emailAddress){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.flights = new ArrayList<Flight>();
    }

    public Passenger(){};

    public
    Long getId(){
        return id;
    }

    public
    void setId(Long id){
        this.id = id;
    }

    public
    String getName(){
        return name;
    }

    public
    void setName(String name){
        this.name = name;
    }

    public
    String getPhoneNumber(){
        return phoneNumber;
    }

    public
    void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public
    String getEmailAddress(){
        return emailAddress;
    }

    public
    void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public
    List<Flight> getFlights(){
        return flights;
    }

    public
    void setFlights(List<Flight> flights){
        this.flights = flights;
    }

    public
    void addFlight(Flight flight){
        this.flights.add(flight);
    }
}
