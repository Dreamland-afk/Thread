package org.dreamquest.designpatterns.composite;
import java.util.List;

public class Manager implements IComponent {
    List<IComponent> subordinates;
    private final String name;
    private final String department;

    public Manager(String name, String department) {
        this.name = name;
        this.department = department;
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
        System.out.println("Manager: " + name + ", Department: " + department);
        if(subordinates != null) {
            for(IComponent component : subordinates) {
                component.operation();
            }
        }
    }

}
