package de.dkwr.testconcepts.vehicel;

import org.springframework.stereotype.Component;

@Component
public class Train implements VehicleIF {
    @Override
    public void move(Speed speedName) {
        System.err.println("Test...");
        // Do specific work on Saturday...
    }
}
