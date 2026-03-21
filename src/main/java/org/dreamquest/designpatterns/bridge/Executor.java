package org.dreamquest.designpatterns.bridge;

public class Executor {
    public static void main(String[] args) {
        AlertNotification alertNotification = new AlertNotification(new EmailSender());
//        new AlertNotification());
        alertNotification.send("This is an alert notification!");

    }
}
