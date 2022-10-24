package de.dkwr.testconcepts.vehicle;

import org.springframework.stereotype.Component;

@Component
public class Train implements VehicleIF {
    @Override
    public void move(Speed speedName) {
        // Do specific work on Saturday...
    }
}
