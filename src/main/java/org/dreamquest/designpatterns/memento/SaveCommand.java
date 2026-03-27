package org.dreamquest.designpatterns.memento;

public class SaveCommand implements ICommand{
    private  ProfileHistory profileHistory;

    public SaveCommand(ProfileHistory profileHistory){
        this.profileHistory = profileHistory;
    }


    @Override
    public void execute() {
        profileHistory.saveState();
    }
}
