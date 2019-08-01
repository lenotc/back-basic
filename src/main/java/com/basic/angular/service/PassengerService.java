package com.basic.angular.service;

import com.basic.angular.model.Passenger;

import java.util.List;

public interface PassengerService
{
    List<Passenger> getPassenger();
    Passenger save(Passenger passenger);
    Passenger findById(Long id);
    void deleteById(Long id);
}
