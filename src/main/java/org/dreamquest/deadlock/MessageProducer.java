package org.dreamquest.deadlock;

import java.util.Random;
import java.util.random.RandomGenerator;

public class MessageProducer implements  Runnable {

    String[] dailyQuotes = {
            "The only way to do great work is to love what you do. - Steve Jobs",
            "Strive not to be a success, but rather to be of value. - Albert Einstein",
            "The future belongs to those who believe in the beauty of their dreams. - Eleanor Roosevelt",
            "The only limit to our realization of tomorrow will be our doubts of today. - Franklin D. Roosevelt",
            "It is never too late to be what you might have been. - George Eliot"
    };

    MessageRepository messageRepository;

    public MessageProducer(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run() {

        Random random = new Random();

        for (String dailyQuote : dailyQuotes) {
            try {
                messageRepository.setMessage(dailyQuote);
                Thread.sleep(random.nextInt(500, 2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
