package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.BearClock;
import pl.sdacademy.animals.time.Clock;


public abstract class Bear implements Animal {

    private double weight;
    private DateTime lastMealTime;
    private Clock clock;
    DateTime hibernatedFrom;
    DateTime hibernatedTo;

    public Bear(double weight) {
        this.weight = weight;
        this.clock = new BearClock();
    }

    public Bear(double weight, Clock clock) {
        this.weight = weight;
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        return hasBearEatenIn10Days();
    }

    public void eat(int eatenMeal) throws IsHibernatedException {
        if (isHibernated()) {
            throw new IsHibernatedException();
        } else {
            weight += eatenMeal;
            this.lastMealTime = clock.getCurrentTime();
        }
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void drink(double waterWeight) {
        weight += waterWeight * 3 / 4;

    }

    public void poop() {
        weight -= weight * 0.05;
    }

    private boolean hasBearEatenIn10Days() {
        return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));
    }

    private boolean isHibernated() {

        if (clock.getCurrentTime().isAfter(hibernatedFrom) && clock.getCurrentTime().isBefore(hibernatedTo)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean monthComparator(DateTime currentClock, DateTime from, DateTime to) {
        if (currentClock.getMonthOfYear() == from.getMonthOfYear()) {
            if (currentClock.getDayOfMonth() > from.getDayOfMonth() && currentClock.getDayOfMonth() > to.getDayOfMonth()) {
                return true;
            }
        } else if (currentClock.getMonthOfYear() > from.getMonthOfYear() && currentClock.getMonthOfYear() < to.getMonthOfYear()) {
            return true;
        }
        return false;
    }
}
