package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.BearClock;


public abstract class Bear implements Animal {

    private int weight;
    private boolean isAlive;
    private DateTime lastMealTime;
    private BearClock clock;

    public Bear(int weight) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = new BearClock();
    }

    public Bear(int weight, BearClock clock) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));

    }

    public void eat() {
        this.lastMealTime = clock.getCurrentTime();
    }

    @Override
    public int getWeight() {
        return weight;
    }

}
