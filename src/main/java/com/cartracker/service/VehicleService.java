package com.cartracker.service;

import com.cartracker.entity.Readings;
import com.cartracker.entity.Vehicle;


import java.util.List;

/**
 * Created by sai on 6/25/17.
 */
public interface VehicleService {

    List<Vehicle> displayAll();

    Vehicle displayOne(String vin);

    Vehicle create(Vehicle vh);

    Vehicle update(String vin, Vehicle vh);

    void delete(String vin);

    List<Readings> displayAllReadings();

    Readings displayOneReadings(String id);

    void createReadings(Readings readings);

    Readings updateReadings(String id, Readings readings);

    void deleteReadings(String id);
}
