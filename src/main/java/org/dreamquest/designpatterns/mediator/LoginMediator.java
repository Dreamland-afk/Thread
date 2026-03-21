package org.dreamquest.designpatterns.mediator;

public class LoginMediator implements Mediator {

    private UserTextBox usernameTextBox;
    private PasswordTextBox passwordTextBox;
    private RememberMeCheckBox rememberMeCheckBox;
    private Button loginButton;
    private Label statusLabel;


    public void setUsernameTextBox(UserTextBox usernameTextBox) {
        this.usernameTextBox = usernameTextBox;
    }

    public void setPasswordTextBox(PasswordTextBox passwordTextBox) {
        this.passwordTextBox = passwordTextBox;
    }

    public void setRememberMeCheckBox(RememberMeCheckBox rememberMeCheckBox) {
        this.rememberMeCheckBox = rememberMeCheckBox;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == usernameTextBox || sender == passwordTextBox) {
            // Rule: enable button only when username is not empty AND password >= 8 chars
            boolean valid = !usernameTextBox.getText().isEmpty()
                    && passwordTextBox.getText().length() >= 8;
            loginButton.setEnabled(valid);
            // Rule: clear any previous error on every keystroke
            statusLabel.clear();

        } else if (sender == loginButton && "click".equals(event)) {
            // Rule: check RememberMe state to decide the message
            if (rememberMeCheckBox.isChecked()) {
                statusLabel.setText("Logging in (will remember you)...");
            } else {
                statusLabel.setText("Logging in...");
            }
        }
    }
}
