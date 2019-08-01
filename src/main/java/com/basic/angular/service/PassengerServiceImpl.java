package com.basic.angular.service;

import com.basic.angular.model.Passenger;
import com.basic.angular.repsitory.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService
{
    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getPassenger()
    {
        List<Passenger> list = new ArrayList<>();
        return (List<Passenger>) passengerRepository.findAll();
    }

    @Override
    public Passenger save(Passenger passenger)
    {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger findById(Long id)
    {
        return passengerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id)
    {
        passengerRepository.deleteById(id);
    }
}
