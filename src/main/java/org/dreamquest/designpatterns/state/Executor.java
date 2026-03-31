package org.dreamquest.designpatterns.state;

public class Executor {
    public static void main(String[] args) {

        TrafficLightContext context = new TrafficLightContext();
        for (int i = 0; i < 10; i++) {
            context.change();
            try {
                Thread.sleep(2000); // Simulate time delay for state change
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
