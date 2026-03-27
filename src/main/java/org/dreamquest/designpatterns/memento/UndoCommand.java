package org.dreamquest.designpatterns.memento;

public class UndoCommand implements ICommand {
    private final ProfileHistory profileHistory;

    public UndoCommand(ProfileHistory profileHistory) {
        this.profileHistory = profileHistory;
    }

    @Override
    public void execute() {
        profileHistory.restoreState();
    }
}
