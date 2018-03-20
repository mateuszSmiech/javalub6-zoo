package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.time.Clock;

public class PolarBear extends Bear {

    public PolarBear(double weight) {
        super(weight);
    }

    public PolarBear(double weight, Clock clock) {
        super(weight, clock);
        hibernatedFrom = DateTime.parse("2017-05-05T21:39:45.618-08:00");
        hibernatedTo = DateTime.parse("2018-10-10T21:39:45.618-08:00");
    }
}
