package org.dreamquest.designpatterns.factory;

public class WindowsButton implements Button {
    @Override
    public void click() {
        System.out.println("Windows Button clicked!");
    }
}
