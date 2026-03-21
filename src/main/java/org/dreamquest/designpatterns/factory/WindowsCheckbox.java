package org.dreamquest.designpatterns.factory;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void check() {
        System.out.println("Windows Checkbox checked!");
    }

    @Override
    public void uncheck() {
        System.out.println("Windows Checkbox unchecked!");
    }
}
