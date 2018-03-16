package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import pl.sdacademy.animals.Animal;
import pl.sdacademy.animals.time.BearClock;

import java.time.Clock;


public abstract class Bear implements Animal {

    private double weight;
    private boolean isAlive;
    private DateTime lastMealTime;
    private BearClock clock;

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

    public Bear(int weight, BearClock clock) {
        this.weight = weight;
        this.isAlive = true;
        this.clock = clock;
    }

    @Override
    public boolean isAlive() {
        if (weight > 0 ) {
            return isAlive;
        } else {
            return isAlive = false;
        }
        //return new Duration(lastMealTime, clock.getCurrentTime()).isShorterThan(Duration.standardDays(10));

    }

    public double eat(int eatenMeal) {
        weight += eatenMeal;
        this.lastMealTime = clock.getCurrentTime();
        return weight;
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

    /*private boolean hasBearEatenIn10Days() {
        if(10 > lastMealTime.dayOfMonth())

    }*/
}
