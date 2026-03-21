package org.dreamquest.deadlock;

import java.util.Random;

public class ShoeWarehouseExecutor {

    private static final Random random = new Random();


    public static void main(String[] args) {

        ShoeWarehouse shoeWarehouse = new ShoeWarehouse();


        Thread  producer = new Thread(() -> {

            for(int i = 0 ; i < 10 ; i++)
            {
                Order order = new Order(
                        random.nextInt(10000,99999),
                        ShoeWarehouse.shoeType[random.nextInt(0,ShoeWarehouse.shoeType.length)],
                        random.nextInt(1,5)
                );

                try {
                    shoeWarehouse.receiveOrder(order);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "Producer");


        producer.start();

        for(int i = 0 ; i < 2 ; i++)
        {
            Thread consumer = new Thread(() -> {

                for(int f = 0 ; f < 5 ; f++)
                {
                    try {
                        Order order = shoeWarehouse.fulfillOrder();
                        System.out.println( Thread.currentThread().getName()+ " Fulfilled Order: " + order);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            });

            consumer.start();
        }
    }
}
