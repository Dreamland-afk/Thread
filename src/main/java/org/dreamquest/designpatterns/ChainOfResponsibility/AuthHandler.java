package org.dreamquest.designpatterns.ChainOfResponsibility;

public class AuthHandler implements IHandler {

    private IHandler next;

    @Override
    public void setNext(IHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.contains("auth")) {
            System.out.println("AuthHandler: Handling authentication for request - " + request);
            // Simulate authentication logic here
        } else {
            System.out.println("AuthHandler: Skipping authentication for request - " + request);
        }
        if (next != null) {
            next.handleRequest(request);
        }
    }
}
