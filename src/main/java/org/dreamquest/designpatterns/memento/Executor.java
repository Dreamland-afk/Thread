package org.dreamquest.designpatterns.memento;

public class Executor {
    public static void main(String[] args) {
        Remote remote = new Remote();

        Thermostat thermostat = new Thermostat(22, 50, true, "password123");
        ProfileHistory profileHistory = new ProfileHistory();

        ICommand saveCommand =  new SaveCommand(profileHistory);
        ICommand undoCommand = new UndoCommand(profileHistory);

        remote.setSaveCommand(saveCommand);
        remote.setUndoCommand(undoCommand);

        profileHistory.setThermostat(thermostat);
        System.out.println("Initial state saved.");
        remote.saveButton();

        Thermostat thermostat1 = new Thermostat(25, 40, false, "password123");
        profileHistory.setThermostat(thermostat1);

        System.out.println("Initial state saved.");
        remote.saveButton();

        System.out.println("State restored to previous configuration.");

        remote.undoButton();
        remote.undoButton();

    }
}
