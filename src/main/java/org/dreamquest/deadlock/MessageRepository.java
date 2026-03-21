package org.dreamquest.deadlock;

public class MessageRepository {

    private String message;
    private boolean isMessageAvailable = false;


    public synchronized String getMessage() throws InterruptedException {
        while(!isMessageAvailable)
        {

            wait();
        }
        this.isMessageAvailable = false;
        notifyAll();
        return message;
    }

    public synchronized void setMessage(String message) throws InterruptedException {

        while (isMessageAvailable){

            wait();
        }
        this.message = message;
        isMessageAvailable = true;
        notifyAll();

    }
}
