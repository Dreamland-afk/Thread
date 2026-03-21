package org.dreamquest.designpatterns.observer;

public class CurrentConditionDisplay implements Observer{
    @Override
    public void update(int temperature, int humidity, int pressure) {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity and " + pressure + " Pa pressure");
    }
}
