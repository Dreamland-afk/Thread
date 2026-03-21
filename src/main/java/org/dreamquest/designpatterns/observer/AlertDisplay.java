package org.dreamquest.designpatterns.observer;

public class AlertDisplay implements Observer{
    private final int threshold;

    public AlertDisplay(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void update(int temperature, int humidity, int pressure) {
        if (temperature > threshold) {
            System.out.println("Alert: Temperature " + temperature + "°C exceeds threshold of " + threshold + "°C!");
        }
    }
}
