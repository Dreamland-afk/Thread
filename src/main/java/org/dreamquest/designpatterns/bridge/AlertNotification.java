package org.dreamquest.designpatterns.bridge;

public class AlertNotification extends Notification {


    public AlertNotification(MessageSender sender) {
        super(sender);

    }

    @Override
    public void send(String message) {
        String alertMessage = "ALERT: " + message;
        messageSender.sendMessage(alertMessage);

    }


}
