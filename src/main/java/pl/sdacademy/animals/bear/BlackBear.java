package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.time.Clock;

public class BlackBear extends Bear {

    public BlackBear(double weight) {
        super(weight);
    }

    public BlackBear(int weight, Clock clock) {
        super(weight, clock);
        hibernatedFrom = new DateTime().withDayOfMonth(20).withMonthOfYear(11).withYear(clock.getCurrentTime().getYear());
        hibernatedTo = new DateTime().withDayOfMonth(15).withMonthOfYear(3).withYear(clock.getCurrentTime().getYear()).plusYears(1);

    }
}

