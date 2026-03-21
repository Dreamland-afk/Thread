package org.dreamquest.designpatterns.mediator;

public class PasswordTextBox implements Component{
    
    private String text;
    private final Mediator mediator;

    public PasswordTextBox(Mediator mediator) {
        this.mediator = mediator;
        this.text = "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        mediator.notify(this, "textChanged");
    }
}
