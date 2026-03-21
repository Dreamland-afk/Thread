package org.dreamquest.designpatterns.mediator;

public class Button implements Component {

    private boolean enabled;
    private final Mediator mediator;

    public Button(Mediator mediator) {
        this.mediator = mediator;
        this.enabled = false; // Initially disabled
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        // ✅ No back-notify — mediator is the one calling this, avoid feedback loop
    }

    public void click() {
        if (enabled) {
            mediator.notify(this, "click");
        }
    }
}
