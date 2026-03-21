package org.dreamquest.threads;

public class Init  extends  Thread {

    @Override
    public void run() {

        long start =  System.currentTimeMillis();
        EvenThread evenThread = new EvenThread("Even Thread");
        Thread oddThread =  new Thread( new OddThread("Odd Thread"));

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {


            System.out.println("Interruption detected  inside init class..." + Thread.currentThread().isInterrupted());
            evenThread.interrupt();
            oddThread.interrupt();
            Thread.currentThread().interrupt();

        }

        System.out.println(evenThread.isInterrupted() + " " +  oddThread.isInterrupted());
        long end =  System.currentTimeMillis();


        System.out.println("Time taken by init method to complete is : " + ( end - start ) );

    }
}
