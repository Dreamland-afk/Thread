package org.dreamquest.designpatterns.decorator;

public class SlackDecorator implements Notifier{
    private final Notifier notifier;
    public SlackDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    @Override
    public void send(String message) {
        notifier.send("Slack Notification: "+message);
    }
}
