package de.dkwr.testconcepts.vehicle;

import org.springframework.stereotype.Component;

@Component
public class Bike implements VehicleIF {
    @Override
    public void move(Speed speedName) {
        // Do Bike specific things
    }
}
