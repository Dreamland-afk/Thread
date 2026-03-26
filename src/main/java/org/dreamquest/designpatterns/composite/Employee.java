package org.dreamquest.designpatterns.composite;

public class Employee implements IComponent {
    private final String name;
    private final String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void operation() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}
