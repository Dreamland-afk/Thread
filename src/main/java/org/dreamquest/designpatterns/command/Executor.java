package org.dreamquest.designpatterns.command;

public class Executor {
    public static void main(String[] args) {

        Light light = new Light();
        Remote remote = new Remote();

        ICommand turnOnCommand = new TurnOnCommand(light);
        ICommand turnOffCommand = new TurnOffCommand(light);

        remote.setCommand(turnOnCommand);
        remote.pressButton();

        remote.setCommand(turnOffCommand);
        remote.pressButton();
    }
}
