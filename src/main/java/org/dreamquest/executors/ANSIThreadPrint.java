package org.dreamquest.executors;

public class ANSIThreadPrint {

    public static void countDown()
    {

        var threadColor = ThreadColor.ANSI_RESET;
        try {
            threadColor = ThreadColor.valueOf("ANSI_"+Thread.currentThread().getName().toUpperCase());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid thread color name.... Ignoring color ....");
        }
        for(int i = 1 ; i <= 20; i++)
        {
            System.out.printf("%s%s %d%n",threadColor.getColor(), Thread.currentThread().getName(), i);
        }

    }
}
