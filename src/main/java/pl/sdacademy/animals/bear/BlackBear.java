package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.time.BearClock;

public class BlackBear extends Bear {


    public BlackBear(double weight) {
        super(weight);
    }

    public BlackBear(int weight, BearClock clock) {
        super(weight, clock);
    }

    public BlackBear(DateTime clock, String hibernatedFrom, String hibernatedTo) {
        super(clock, hibernatedFrom, hibernatedTo);
    }




}

