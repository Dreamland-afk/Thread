package org.dreamquest.deadlock;

import java.util.Random;

public class MessageConsumer implements Runnable{

    MessageRepository messageRepository;

    public MessageConsumer(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run() {

        Random random = new Random();
        String message = null;
        try {
            for(int i=0; i< 5; i++)
            {
                System.out.println(i);
                message = messageRepository.getMessage();
                Thread.sleep(random.nextInt(500, 2000));
                System.out.println("Message Received..." + message);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
