package org.dreamquest.tvolatile;

import com.sun.source.tree.CatchTree;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    public static void main(String[] args) {

        Notification notification =  new Notification();

        Thread initiate = new Thread(() -> {


            try {
                TimeUnit.SECONDS.sleep(1);
                notification.toggle();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            System.out.println("Inititiated from the first thread: " + notification.isready());
        });

        Thread consume = new Thread(() -> {

//            try {
//                TimeUnit.SECONDS.sleep(1);
//
//                while(!notification.isready())
//                {
//
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }

            while(!notification.isready())
            {

            }


            System.out.println(" Consumed from the second thread: "+notification.isready());
        });


        initiate.start();
        consume.start();


    }
}

class Notification {

   private volatile boolean check = false;

    public void toggle()
    {
        check = !check;
    }

    public boolean isready()
    {
        return check;
    }
}
