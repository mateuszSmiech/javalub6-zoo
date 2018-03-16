package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import pl.sdacademy.animals.Animal;


public abstract class Bear implements Animal {

    private double weight;
    private boolean isAlive;
    private DateTime lastMealTime;

    public Bear(double weight) {
        this.weight = weight;
        this.isAlive = true;
    }

    public Bear(double weight, DateTime lastMealTime) {
        this.weight = weight;
        this.isAlive = true;
        this.lastMealTime = lastMealTime;
    }

    @Override
    public boolean isAlive() {
        if (weight > 0 ) {
            return isAlive;
        } else {
            return isAlive = false;
        }

    }

    public double eat(int eatenMeal) {
        weight += eatenMeal;
        lastMealTime = DateTime.now();
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
