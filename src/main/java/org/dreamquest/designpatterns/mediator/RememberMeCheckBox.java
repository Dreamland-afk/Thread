package org.dreamquest.designpatterns.mediator;

public class RememberMeCheckBox implements Component {

    private boolean checked;
    private final Mediator mediator;

    public RememberMeCheckBox(Mediator mediator) {
        this.mediator = mediator;
            this.checked = false; // Initially unchecked
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        mediator.notify(this, "checkedChanged"); // ✅ Uncommented
    }
}
