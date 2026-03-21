package org.dreamquest.designpatterns.mediator;

/**
 * Problem statement (Mediator pattern): “Smart Dialog Controller”
 *
 * You are building a Login Dialog UI that contains these components:
 *
 * UsernameTextBox
 * PasswordTextBox
 * RememberMeCheckBox
 * LoginButton
 * StatusLabel
 * Rules (interaction logic)
 * LoginButton must be enabled only when:
 * username is not empty, AND
 * password length is >= 8
 * Whenever the user changes username/password:
 * StatusLabel should clear any previous error message.
 * When the user clicks LoginButton:
 * if RememberMeCheckBox is checked → set StatusLabel to "Logging in (will remember you)..."
 * else → set StatusLabel to "Logging in..."
 * No component is allowed to directly call methods on another component (e.g., UsernameTextBox cannot call LoginButton.setEnabled()).
 * Task
 * Implement the Mediator design pattern to satisfy the rules:
 *
 * Create a Mediator interface like notify(sender, event).
 * Create a LoginDialogMediator that contains references to all components and implements all rules.
 * Create component classes (TextBox, CheckBox, Button, Label) that:
 * store only their own state
 * call mediator.notify(this, event) when they change
 * Write a main() (or a test) that simulates:
 * typing username
 * typing short password (button remains disabled)
 * typing valid password (button becomes enabled)
 * checking RememberMe
 * clicking Login (label changes based on RememberMe)
 * Goal: You should see that all coordination happens in LoginDialogMediator, and components remain decoupled/reusable.
 */
public class Executor {
    public static void main(String[] args) {
        LoginMediator mediator = new LoginMediator();

        UserTextBox usernameTextBox = new UserTextBox(mediator);
        PasswordTextBox passwordTextBox = new PasswordTextBox(mediator);
        RememberMeCheckBox rememberMeCheckBox = new RememberMeCheckBox(mediator);
        Button loginButton = new Button(mediator);
        Label statusLabel = new Label(mediator);

        mediator.setUsernameTextBox(usernameTextBox);
        mediator.setPasswordTextBox(passwordTextBox);
        mediator.setRememberMeCheckBox(rememberMeCheckBox);
        mediator.setLoginButton(loginButton);
        mediator.setStatusLabel(statusLabel);

        // Simulate user interactions
        usernameTextBox.setText("user123");
        passwordTextBox.setText("short"); // Button remains disabled
        passwordTextBox.setText("validPassword"); // Button becomes enabled
        rememberMeCheckBox.setChecked(true); // Checking RememberMe
        loginButton.click(); // Clicking Login (label changes based on RememberMe)

    }
}
