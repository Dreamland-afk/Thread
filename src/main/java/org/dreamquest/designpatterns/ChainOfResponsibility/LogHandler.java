package org.dreamquest.designpatterns.ChainOfResponsibility;

public class LogHandler implements IHandler {

    private IHandler next;

    @Override
    public void setNext(IHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(String request) {
        System.out.println("LogHandler: Logging request - " + request);
        if (next != null) {
            next.handleRequest(request);
        }
    }
}
