package org.dreamquest.designpatterns.state;

public class TrafficLightContext {
    private IState trafficLightState;

    public TrafficLightContext() {
        trafficLightState = new RedLight();
    }

    public void setState(IState state) {
        trafficLightState = state;
    }

    public void change(){
        trafficLightState.handleRequest(this);
    }

}
