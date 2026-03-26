package org.dreamquest.designpatterns.composite;

public class Executor {
    public static void main(String[] args) {

        // Create employees
        Employee emp1 = new Employee("Alice", "Developer");
        Employee emp2 = new Employee("Bob", "Designer");
        Manager manager1 = new Manager("Charlie", "R&D");
        Manager manager2 = new Manager("Eve", "Marketing");
        IComponent emp4 = new Employee("David", "Developer");

        // Build the organizational structure
        manager1.addSubordinate(emp1);
        manager1.addSubordinate(emp4);
        manager2.addSubordinate(emp2);

        SeniorManager seniorManager = new SeniorManager("Frank", "CTO");
        seniorManager.addSubordinate(manager1);
        seniorManager.addSubordinate(manager2);

        // Execute the operation
        seniorManager.operation();

    }
}
