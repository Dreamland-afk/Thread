package org.dreamquest.deadlock;

public class Executor {

    public static void main(String[] args) throws InterruptedException {

        MessageRepository messageRepository = new MessageRepository();

        Thread producer = new Thread(new MessageProducer(messageRepository), "producer");
        Thread consumer = new Thread(new MessageConsumer(messageRepository), "consumer");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
