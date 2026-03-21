package org.dreamquest.designpatterns.factory;

public class MacButton implements Button {

    MacButton (){
        System.out.println("Mac Button created!");
        click();
    }
    @Override
    public void click() {
        System.out.println("Mac Button clicked!");
    }
}
