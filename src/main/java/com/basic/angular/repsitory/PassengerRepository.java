package com.basic.angular.repsitory;

import com.basic.angular.model.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long>
{
}
