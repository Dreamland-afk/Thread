package org.dreamquest.designpatterns.memento;

public class Remote {
    private ICommand saveCommand;
    private ICommand undoCommand;

    public void setSaveCommand(ICommand iCommand) {
        this.saveCommand = iCommand;
    }
    public void setUndoCommand(ICommand iCommand) {
        this.undoCommand = iCommand;
    }

    public void saveButton() {
        if (saveCommand != null) {
            saveCommand.execute();
        } else {
            System.out.println("Save command set.");
        }
    }

    public void undoButton() {
        if (undoCommand != null) {
            undoCommand.execute();
        } else {
            System.out.println("undo command set.");
        }
    }
}
