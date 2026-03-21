package org.dreamquest.designpatterns.observer;

/*
Problem statement (Observer pattern):

Design and implement a Weather Station notification system.

Requirements:

Create a WeatherStation (Subject/Publisher) that maintains the latest readings: temperature, humidity, and pressure.
Create an Observer interface with an update(temperature, humidity, pressure) method.
Implement at least three observers:
CurrentConditionsDisplay – shows the latest values
StatisticsDisplay – shows min/avg/max temperature
AlertDisplay – triggers an alert when temperature exceeds a threshold (e.g., > 40°C)
The WeatherStation must support:
registerObserver(observer)
removeObserver(observer)
notifyObservers()
When new sensor data arrives via setMeasurements(t, h, p), the station must notify all registered observers automatically.
Demonstrate in a main()/driver program:
registering observers
updating measurements multiple times
removing one observer and showing it no longer receives updates.
 */
public class Executor {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        AlertDisplay alertDisplay = new AlertDisplay(40); // Alert threshold set to 40°C

        weatherStation.registerObserver(currentDisplay);
        weatherStation.registerObserver(statisticsDisplay);
        weatherStation.registerObserver(alertDisplay);

        System.out.println("First update:");
        weatherStation.setMeasurements(25, 65, 1013);

        System.out.println("\nSecond update:");
        weatherStation.setMeasurements(30, 70, 1012);

        System.out.println("\nThird update (exceeds alert threshold):");
        weatherStation.setMeasurements(45, 80, 1010);

        System.out.println("\nRemoving StatisticsDisplay observer...");
        weatherStation.removeObserver(statisticsDisplay);

        System.out.println("\nFourth update (StatisticsDisplay should not receive this):");
        weatherStation.setMeasurements(28, 60, 1015);
    }
}
