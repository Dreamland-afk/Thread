package org.dreamquest.designpatterns.bridge;

public class EmailNotification extends Notification{

    protected EmailNotification(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    protected void send(String message) {
        String email = "Email: " + message;
        messageSender.sendMessage(email);
    }
}
