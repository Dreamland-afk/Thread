package org.dreamquest.designpatterns.command;

public class Remote {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned to the remote.");
        }
    }
}
