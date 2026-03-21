package org.dreamquest.designpatterns.factory;

/**
 *Problem Statement (Abstract Factory Design Pattern)
 *
 * You are building a cross-platform UI application that must run on multiple operating systems (e.g., Windows and macOS). Each operating system requires a different “family” of UI components that are designed to work together, such as Button, Checkbox, and TextField.
 *
 * Constraints / Challenges:
 * - The application code should not depend on concrete UI classes like WindowsButton or MacButton.
 * - The UI components created for a given OS must be consistent (e.g., if the OS is Windows, all components should be Windows-styled).
 * - Adding support for a new OS (e.g., Linux) should require minimal changes to existing client code.
 *
 * Requirement:
 * Design a solution that provides an interface for creating families of related UI objects (Button, Checkbox, TextField) without specifying their concrete classes, and allows the application to select the correct family at runtime based on configuration.

 * Expected Outcome:
 * - A set of abstract product interfaces (Button, Checkbox, TextField)
 * - Concrete product implementations for each OS (WindowsButton/MacButton, etc.)
 * - An Abstract Factory interface that creates the products
 * - Concrete factories (WindowsUIFactory, MacUIFactory) that produce matching product families
 * - Client code that uses only the abstract factory and product interfaces
 */
public class Executor {

    public static void main(String[] args) {

        UICreate macUi = Factory.getFactory().getUI("Mac");
        macUi.createButton();
        macUi.createCheckbox();

    }
}
