package org.dreamquest.designpatterns.composite;

import java.util.List;

public class SeniorManager implements IComponent {
    List<IComponent> subordinates;
    private final String name;
    private final String position;

    public SeniorManager(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void addSubordinate(IComponent component) {
        if(subordinates == null) {
            subordinates = new java.util.ArrayList<>();
        }
        subordinates.add(component);
    }

    public void removeSubordinate(IComponent component) {
        if(subordinates != null) {
            subordinates.remove(component);
        }
    }

    @Override
    public void operation() {
        System.out.println("Senior Manager: " + name + ", Position: " + position);
        if(subordinates != null) {
            for(IComponent component : subordinates) {
                component.operation();
            }
        }
    }
}
