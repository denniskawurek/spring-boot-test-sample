package de.dkwr.testconcepts.driver;

import de.dkwr.testconcepts.vehicel.Train;
import de.dkwr.testconcepts.vehicel.Bike;
import de.dkwr.testconcepts.vehicel.Speed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class DriverComponent {
    @Autowired
    Bike bike;

    @Autowired
    Train train;

    public void execute() {
        boolean isSaturday = LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SATURDAY);
        boolean isSunday = LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.SUNDAY);

        if (isSunday) {
            return;
        }

        if (isSaturday) {
            train.move(Speed.FAST);
            return;
        }

        bike.move(Speed.MEDIUM);
    }
}
