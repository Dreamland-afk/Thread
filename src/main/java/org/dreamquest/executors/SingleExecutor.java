package org.dreamquest.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class SingleExecutor {

    public static void main(String[] args) throws RuntimeException {

       var green = Executors.newSingleThreadExecutor(new CustomThreadName("green"));
       green.execute(ANSIThreadPrint::countDown);
       green.shutdown();

        try {
             if(green.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                 var blue = Executors.newSingleThreadExecutor(new CustomThreadName("blue"));
                 blue.execute(ANSIThreadPrint::countDown);
                 blue.shutdown();

                 try {
                     if (blue.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                         var red = Executors.newSingleThreadExecutor(new CustomThreadName("red"));
                         red.execute(ANSIThreadPrint::countDown);
                         red.shutdown();

                         try {
                             red.awaitTermination(500, TimeUnit.MILLISECONDS);
                         } catch (InterruptedException e) {
                             throw new RuntimeException(e);
                         }
                     }
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
