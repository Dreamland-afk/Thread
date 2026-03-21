package org.dreamquest.designpatterns.ChainOfResponsibility;

public class AuditHandler implements IHandler {

    private IHandler next;

    @Override
    public void setNext(IHandler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (request.contains("audit")) {
            System.out.println("AuditHandler: Auditing request - " + request);
            // Simulate auditing logic here
        } else {
            System.out.println("AuditHandler: Skipping audit for request - " + request);
        }
        if (next != null) {
            next.handleRequest(request);
        }
    }
}
