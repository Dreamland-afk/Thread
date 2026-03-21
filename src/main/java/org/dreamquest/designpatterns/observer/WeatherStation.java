package org.dreamquest.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation {
    List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    private void notifyObservers(Weather weather) {
        for (Observer observer : observers) {
            observer.update(weather.temperature(), weather.humidity(), weather.pressure());
        }
    }

    public void setMeasurements(int temperature, int humidity, int pressure) {
        Weather weather = new Weather(temperature, humidity, pressure);
        notifyObservers(weather);
    }


}
