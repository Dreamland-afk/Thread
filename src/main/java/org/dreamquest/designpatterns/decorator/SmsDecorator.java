package org.dreamquest.designpatterns.decorator;

public class SmsDecorator implements Notifier{
    private final Notifier notifier;
    public SmsDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    @Override
    public void send(String message) {
        notifier.send("SMS Notification: "+message);
    }
}
