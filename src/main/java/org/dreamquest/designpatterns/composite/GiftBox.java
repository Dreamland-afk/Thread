package org.dreamquest.designpatterns.composite;

import java.util.List;

public class GiftBox implements IProductComponent{

    private final String name;
    List<IProductComponent> items;
    public GiftBox(String name) {
        this.name = name;
    }

    public void add(IProductComponent component) {
        if(items == null) {
            items = new java.util.ArrayList<>();
        }
        items.add(component);
    }

    public void remove(IProductComponent component){
        if (items != null) {
            items.remove(component);
        }
    }

    @Override
    public double operation() {
        double totalPrice = 0;
        System.out.println("GiftBox: " + name);
        if(items != null) {
            for(IProductComponent component : items) {
                totalPrice+= component.operation();
            }
        }
        return totalPrice;
    }


}
