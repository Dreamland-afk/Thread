package org.dreamquest.designpatterns.command;

public class TurnOffCommand implements ICommand {
    private final Light light;

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
