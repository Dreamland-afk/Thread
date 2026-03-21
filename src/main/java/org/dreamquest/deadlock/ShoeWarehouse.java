package org.dreamquest.deadlock;

import java.util.ArrayList;
import java.util.List;

public class ShoeWarehouse {

    public static String[]  shoeType = {"Casual","Running","Sandal", "Boots", "High Tops"};

    private final List<Order> orders;

    public ShoeWarehouse()
    {
        orders = new ArrayList<>();

    }


    public synchronized void receiveOrder(Order order) throws InterruptedException {

        while(orders.size() > 20)
        {
            wait();
        }

        System.out.println("Incoming order: "+order);
        orders.add(order);
        notifyAll();
    }

    public synchronized Order fulfillOrder() throws InterruptedException {

        while(orders.isEmpty())
        {
            wait();
        }

        Order item = orders.removeFirst();
        notifyAll();
        return item;
    }

}
