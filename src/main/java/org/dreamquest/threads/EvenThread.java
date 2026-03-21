package org.dreamquest.threads;

public class EvenThread extends Thread {

    public EvenThread() {


    }
    public EvenThread(String name) {
        super.setName(name);

    }
    @Override
    public void run() {
        for( int i = 0; i < 10; i++)
        {
            try {
                Thread.sleep(550);
                if( i%2 == 0 )
                    System.out.println(this.getName() +" "+i );

            } catch (InterruptedException e) {
                System.out.println(" EvenThread:  " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                return;

            }

//            System.out.println(" EvenThread:  " + Thread.currentThread().isInterrupted());
        }
    }
}
