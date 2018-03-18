package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.sdacademy.animals.time.BearClock;

import java.time.Clock;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void isHibernated()  {
        //Bear is hibernated
        DateTime time = DateTime.parse("2017-12-13T21:39:45.618-08:00");
        Bear bear = new BlackBear(time, "20/11/2017", "15/03/2018");

        Throwable ex = assertThrows(IsHibernatedException.class, () -> bear.eat(2));
        assertEquals("Bear is hibernated.", ex.getMessage());
    }
}