package org.dreamquest.banking;

import java.util.concurrent.TimeUnit;

public class BankAppDriver {
    public static void main(String[] args) throws InterruptedException {

//        while (true) {

            TimeUnit.SECONDS.sleep(1);
            BankApp bankApp = new BankApp("Swapnadeep",10000);
            LockClass lockClass = new LockClass();

            Thread w1 = new Thread(() -> bankApp.withdrawal(2500));
            Thread d1 = new Thread(() -> bankApp.deposit(5000));

            Thread w2 = new Thread(() -> bankApp.withdrawal(2500));
            Thread u1 = new Thread(() -> bankApp.setName("Rohan"));
            Thread w3 = new Thread(() -> bankApp.withdrawal(2500));


            Thread p1 = new Thread(lockClass::print);







            w1.start();
            d1.start();


            Thread.sleep(500);
            w2.start();
            u1.start();
            w3.start();

            Thread.sleep(8000);

            System.out.println("After 8sec");
            p1.start();


            w1.join();
            d1.join();
            w2.join();
            u1.join();
            w3.join();
//            p1.join();


            System.out.println("Current balance after all transaction is : "
                    + bankApp.getBalance());
            System.out.println("...............................");

//        }
    }
}
