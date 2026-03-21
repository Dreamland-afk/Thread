package org.dreamquest;

import org.dreamquest.threads.EvenThread;
import org.dreamquest.threads.Init;
import org.dreamquest.threads.OddThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Init init = new Init();
        init.setName("Init Thread");

        long start = System.currentTimeMillis();

        Thread monitoringThread = new Thread(() -> {

            try {
                Thread.sleep(1500);
                if (System.currentTimeMillis() - start > 1500)
                    init.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


        init.start();
        monitoringThread.start();

        init.join();
        monitoringThread.join();

        System.out.println("Is init interrupted? "+init.isInterrupted());

        if (init.isInterrupted()) {
            System.out.println(init.getName() + " is interrupted !!");
            System.exit(0);
        }


        System.out.println(init.getName() + " is not interrupted !!");


    }
}