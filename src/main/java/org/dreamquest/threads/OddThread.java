package org.dreamquest.threads;

public class OddThread implements Runnable{

    private String threadName;

    public OddThread() {


    }
    public OddThread(String name) {
        this.threadName = name;

    }
    @Override
    public void run() {

        for( int i = 0; i < 10; i++)
        {
            try {
                Thread.sleep(500);
                if( i%2 != 0 )
                    System.out.println(threadName +" "+i);

            } catch (InterruptedException e) {

                System.out.println(" OddThread:  " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                return;

            }
        }
    }
}
