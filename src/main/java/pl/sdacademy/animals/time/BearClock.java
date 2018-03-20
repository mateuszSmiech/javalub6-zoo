package pl.sdacademy.animals.time;

import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;

public class BearClock implements Clock {

    //DateTime date;

    @Override
    public DateTime getCurrentTime() {
        return DateTime.now();
    }

    /*public void setDate(DateTime date) {
        this.date = date;
    }*/
}
