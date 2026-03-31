package org.dreamquest.designpatterns.state;

public class GreenLight implements IState{


    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Green Light: Cars can go.");
        context.setState(new YellowLight());

    }


}
