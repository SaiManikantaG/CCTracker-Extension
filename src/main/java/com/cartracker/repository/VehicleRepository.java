package com.cartracker.repository;

import com.cartracker.entity.Readings;
import com.cartracker.entity.Vehicle;

import java.util.List;

/**
 * Created by sai on 6/25/17.
 */


public interface VehicleRepository {

    List<Vehicle> displayAll();

    Vehicle displayOne(String vin);

    Vehicle create(Vehicle vh);

    Vehicle update(Vehicle vh);

    void delete(Vehicle vh);

    List<Readings> displayAllReadings();

    Readings displayOneReadings(String id);

    Readings createReadings(Readings readings);

    Readings updateReadings(Readings readings);

    void deleteReadings(Readings readings);

}
