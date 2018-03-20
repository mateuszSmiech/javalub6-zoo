package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.sdacademy.animals.time.BearClock;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BearTest {

    @Test
    void isHibernated()  {
        //Bear is hibernated
        BearClock clock = mock(BearClock.class);
        when(clock.getCurrentTime()).thenReturn(DateTime.now());
        Bear bear = new BlackBear(3, clock);
        when(clock.getCurrentTime()).thenReturn(DateTime.parse("2018-12-14T21:39:45.618-08:00"));

        Throwable ex = assertThrows(IsHibernatedException.class, () -> bear.eat(2));
        assertEquals("Bear is hibernated.", ex.getMessage());
    }
}