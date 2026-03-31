package org.dreamquest.designpatterns.state;

public class RedLight implements IState{
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Red Light - Stop!");
        context.setState(new GreenLight());

    }

}
