package com.cartracker.controller;

import com.cartracker.entity.Readings;
import com.cartracker.entity.Vehicle;
import com.cartracker.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sai on 6/25/17.
 */


@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class VehicleController {

    @Autowired
    VehicleService service;


    /* Vehicle services*/
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> displayAll() {
        return service.displayAll();
    }

    @CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.OPTIONS,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle displayOne(@PathVariable("vin") String vin) {
        return service.displayOne(vin);
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody Vehicle[] Vehicle) {
        for (Vehicle vh : Vehicle) {
            service.create(vh);
            System.out.println(vh.toString());
        }
    }

    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vin") String vin, @RequestBody Vehicle vh) {
        return service.update(vin, vh);
    }

    @RequestMapping(value = "/vehicles/{vin}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }


    /* Reading service*/


    @RequestMapping(value = "/readings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> displayAllReadings() {
        return service.displayAllReadings();
    }

    @RequestMapping(value = "/readings/{id}", method = RequestMethod.OPTIONS,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings displayOneReadings(@PathVariable("id") String id) {
        return service.displayOneReadings(id);
    }

    @RequestMapping(value = "/readings", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createReadings(@RequestBody Readings[] Readings) {
        for (Readings readings : Readings) {
            service.createReadings(readings);
            System.out.println(readings.toString());
        }

    }

    @RequestMapping(value = "/readings/{vin}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings updateReadings(@PathVariable("id") String id, @RequestBody Readings readings) {
        return service.updateReadings(id, readings);
    }


    @RequestMapping(value = "/readings/{vin}", method = RequestMethod.DELETE)
    public void deleteReadings(@PathVariable("id") String id) {
        service.delete(id);
    }




}
