package com.basic.angular.controller;


import com.basic.angular.model.Passenger;
import com.basic.angular.service.PassengerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class PassengerController
{
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/passengers")
    public List<Passenger> getPassengers()
    {
        return passengerService.getPassenger();
    }

    @GetMapping("/passengers/{id}")
    public Passenger getPassenger(@PathVariable Long id)
    {
        return passengerService.findById(id);
    }

    @PutMapping("/passengers/{id}")
    public Passenger updatedPassenger(@PathVariable Long id, @RequestBody Passenger passenger)
    {
        Passenger oldPassenger = passengerService.findById(id);

        BeanUtils.copyProperties(passenger, oldPassenger);

        passengerService.save(oldPassenger);

        return oldPassenger;
    }

    @DeleteMapping("/passengers/{id}")
    public Passenger deletePassenger(@PathVariable Long id)
    {
        Passenger passenger = passengerService.findById(id);
        passengerService.deleteById(id);
        return passenger;
    }
}
