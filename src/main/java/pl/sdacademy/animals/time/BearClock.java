package pl.sdacademy.animals.time;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

public class BearClock {
    public DateTime getCurrentTime() {
        return DateTime.now();
    }
}
