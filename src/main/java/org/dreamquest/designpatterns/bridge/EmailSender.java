package org.dreamquest.designpatterns.bridge;

public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending REPORT via EMAIL: " + message);
    }


}
