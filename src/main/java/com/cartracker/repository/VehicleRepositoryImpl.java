package com.cartracker.repository;

import com.cartracker.entity.Readings;
import com.cartracker.entity.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sai on 6/25/17.
 */

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Vehicle> displayAll() {

        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.displayAll", Vehicle.class);
        return query.getResultList();

    }

    public Vehicle displayOne(String vin) {
        return entityManager.find(Vehicle.class, vin);

    }


    public Vehicle create(Vehicle vh) {
        entityManager.persist(vh);
        return vh;

    }

    public Vehicle update(Vehicle vh) {
        return entityManager.merge(vh);

    }

    public void delete(Vehicle vh) {
        entityManager.remove(vh);

    }

    public List<Readings> displayAllReadings(){

        TypedQuery<Readings> query = entityManager.createNamedQuery("Readings.displayAllReading", Readings.class);
        return query.getResultList();
    }

    public Readings displayOneReadings(String id){
        return entityManager.find(Readings.class, id);
    }

    public Readings createReadings(Readings readings) {
        entityManager.persist(readings);
        return readings;

    }

    public Readings updateReadings(Readings readings) {
        return entityManager.merge(readings);

    }

    public void deleteReadings(Readings readings) {
        entityManager.remove(readings);

    }




}
