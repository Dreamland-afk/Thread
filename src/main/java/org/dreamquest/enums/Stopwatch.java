package org.dreamquest.enums;

import java.util.concurrent.TimeUnit;

public class Stopwatch {

    
    private TimeUnit timeUnit;
    private int i =0 ;

    public Stopwatch() {
        this.timeUnit = TimeUnit.SECONDS;
    }
    public Stopwatch(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void countdown()  {
        countdown(5);
    }
    public void countdown(int time) {

        String threadColorName = Thread.currentThread().getName();
        ThreadColor color = ThreadColor.ANSI_RESET;

        try{

            color = ThreadColor.valueOf(threadColorName);

        }catch (IllegalArgumentException ignore)
        {
            System.out.println("Invalid thread name... Stopping");
            Thread.currentThread().interrupt();
            return;
        }

        for( i = time; i > 0 ; i--)
        {
            try {
                timeUnit.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s %s Thread i = %d%n", color.getColor(), threadColorName, i);
        }

        
        


    }

}
