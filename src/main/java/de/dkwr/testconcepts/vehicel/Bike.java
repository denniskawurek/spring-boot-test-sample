package de.dkwr.testconcepts.vehicel;

import org.springframework.stereotype.Component;

@Component
public class Bike implements VehicleIF {
    @Override
    public void move(Speed speedName) {
        System.err.println("Test 2...");
        // Do Bike specific things
    }
}
