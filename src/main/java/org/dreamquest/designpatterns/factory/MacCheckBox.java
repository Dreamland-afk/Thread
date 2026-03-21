package org.dreamquest.designpatterns.factory;

public class MacCheckBox implements Checkbox {
    @Override
    public void check() {
        System.out.println("Mac CheckBox checked!");
    }

    @Override
    public void uncheck() {
        System.out.println("Mac CheckBox unchecked!");
    }

}
