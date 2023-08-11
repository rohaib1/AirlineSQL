package com.bnta.AirlineApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String destination;
    @Column
    private int capacity;
    @Column
    private String departureDate;
    @Column
    private String departureTime;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnoreProperties("flights")
    private List<Passenger> passenger;

    public Flight(String destination, int capacity, String departureDate, String departureTime) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passenger = new ArrayList<Passenger>();
    }

    public Flight (){}

    public
    Long getId(){
        return id;
    }

    public
    void setId(Long id){
        this.id = id;
    }

    public
    String getDestination(){
        return destination;
    }

    public
    void setDestination(String destination){
        this.destination = destination;
    }

    public
    int getCapacity(){
        return capacity;
    }

    public
    void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public
    String getDepartureDate(){
        return departureDate;
    }

    public
    void setDepartureDate(String departureDate){
        this.departureDate = departureDate;
    }

    public
    String getDepartureTime(){
        return departureTime;
    }

    public
    void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }

    public
    List<Passenger> getPassenger(){
        return passenger;
    }

    public
    void setPassenger(List<Passenger> passenger){
        this.passenger = passenger;
    }
}
