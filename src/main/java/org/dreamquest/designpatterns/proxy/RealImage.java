package org.dreamquest.designpatterns.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

public class RealImage implements Image {
    private final String filename;
    RealImage(String filename) {
        try {
            System.out.println("Loading real image...");
            Thread.sleep(3000); // Simulate time-consuming operation
            this.filename = filename;
            System.out.println("Real image loaded: " + filename);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void display() {
        System.out.println("Displaying real image: " + filename);
    }
}
