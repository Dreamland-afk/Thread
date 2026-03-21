package org.dreamquest.designpatterns.observer;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StatisticsDisplay implements Observer{
    List<Integer> temperatureReadings;
    @Override
    public void update(int temperature, int humidity, int pressure) {
        if(temperatureReadings == null) {
            temperatureReadings = new ArrayList<>();
        }
        temperatureReadings.add(temperature);
        display();
    }

    public void display() {
        IntSummaryStatistics stats = temperatureReadings.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println("Average Temperature: " + (int) stats.getAverage());
        System.out.println("Max Temperature: " + stats.getMax());
        System.out.println("Min Temperature: " + stats.getMin());
    }
}
