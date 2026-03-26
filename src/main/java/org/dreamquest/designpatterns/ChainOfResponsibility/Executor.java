package org.dreamquest.designpatterns.ChainOfResponsibility;

public class Executor {
    public static void main(String[] args) {
        // Create handlers
        IHandler logHandler = new LogHandler();
        IHandler authHandler = new AuthHandler();
        IHandler auditHandler = new AuditHandler();

        // Set up the chain of responsibility
        logHandler.setNext(authHandler);
        authHandler.setNext(auditHandler);

        // Process a request through the chain
        String request = "This is a request that requires audit.";
        logHandler.handleRequest(request);
    }
}
