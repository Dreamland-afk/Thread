package org.dreamquest.designpatterns.bridge;

public class SmsSender implements MessageSender{
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
