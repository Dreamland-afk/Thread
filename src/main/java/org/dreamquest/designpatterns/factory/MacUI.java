package org.dreamquest.designpatterns.factory;

public class MacUI implements UICreate{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckBox();
    }
}
