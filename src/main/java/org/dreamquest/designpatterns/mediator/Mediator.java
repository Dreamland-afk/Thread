package org.dreamquest.designpatterns.mediator;

public interface Mediator {
    void notify(Component sender, String event);
}
