package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.BearClock;


public abstract class Bear implements Animal {

    private double weight;
    private boolean isAlive;
    private DateTime lastMealTime;
    private BearClock clock;
    private String hibernatedFrom;
    private String hibernatedTo;
    private DateTime clockVar;

    public Bear(double weight) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = new BearClock();
    }

    public Bear(double weight, BearClock clock) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = clock;
    }

    public Bear(DateTime clockVar, String hibernatedFrom, String hibernatedTo) {
        this.clockVar = clockVar;
        this.hibernatedFrom = hibernatedFrom;
        this.hibernatedTo = hibernatedTo;
    }

    @Override
    public boolean isAlive() {
        if (hasBearEatenIn10Days()) {
            return isAlive;
        } else {
            return isAlive = false;
        }
    }

    public double eat(int eatenMeal) throws IsHibernatedException {
        if(isHibernated()){
            throw new IsHibernatedException();
        } else {
            weight += eatenMeal;
            this.lastMealTime = clock.getCurrentTime();
            return weight;
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
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime fromDate = formatter.parseDateTime(hibernatedFrom);
        DateTime toDate = formatter.parseDateTime(hibernatedTo);
        if (clockVar.isAfter(fromDate) && clockVar.isBefore(toDate)) {
            return true;
        } else {
            return false;
        }
    }
}
