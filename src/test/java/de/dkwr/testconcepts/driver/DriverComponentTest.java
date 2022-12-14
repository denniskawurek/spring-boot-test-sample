package de.dkwr.testconcepts.driver;

import de.dkwr.testconcepts.vehicle.Train;
import de.dkwr.testconcepts.vehicle.Bike;
import de.dkwr.testconcepts.vehicle.Speed;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class DriverComponentTest {
    MockedStatic<LocalDateTime> localDateTimeMocked;

    @Mock
    Train train;

    @Mock
    Bike bike;

    @InjectMocks
    DriverComponent driverComponent;

    @AfterEach
    void tearDown() {
        localDateTimeMocked.closeOnDemand();
    }

    @Test
    public void executesTrainOnSaturday() {
        localDateTimeMocked = Mockito.mockStatic(LocalDateTime.class, Mockito.CALLS_REAL_METHODS);
        LocalDateTime now = LocalDateTime.of(2022, 10, 22, 10, 0);
        localDateTimeMocked.when(LocalDateTime::now).thenReturn(now);

        driverComponent.execute();

        Mockito.verifyNoInteractions(bike);
        ArgumentCaptor<Speed> speedCaptor = ArgumentCaptor.forClass(Speed.class);
        Mockito.verify(train, Mockito.times(1))
                .move(speedCaptor.capture());

        Assertions.assertEquals(speedCaptor.getValue(), Speed.FAST);
    }
}
