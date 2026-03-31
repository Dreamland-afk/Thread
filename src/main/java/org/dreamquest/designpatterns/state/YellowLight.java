package org.dreamquest.designpatterns.state;

public class YellowLight implements IState{
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Yellow Light: Prepare to stop");
        context.setState(new RedLight());
    }


}
