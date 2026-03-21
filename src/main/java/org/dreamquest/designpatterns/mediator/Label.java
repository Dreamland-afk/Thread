package org.dreamquest.designpatterns.mediator;

public class Label implements Component {

    private String text;
    private final Mediator mediator;

    public Label(Mediator mediator) {
        this.mediator = mediator;
        this.text = ""; // Initially empty
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        System.out.println("[Label] " + text);
    }

    // ✅ Explicit clear — mediator calls this instead of setText("")
    public void clear() {
        this.text = "";
    }
}
