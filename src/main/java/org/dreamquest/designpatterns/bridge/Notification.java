package org.dreamquest.designpatterns.bridge;

public abstract class Notification {

    protected final MessageSender messageSender;

    protected Notification(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    protected abstract void send(String message);
}
