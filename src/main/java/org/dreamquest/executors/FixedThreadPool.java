package org.dreamquest.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {

        int initialThreadCount = 3;

        try (ExecutorService executorService = Executors.newFixedThreadPool(initialThreadCount, new CustomThreadName())) {

            for(int i = 0; i < 6; i++)
            {
                executorService.submit(ANSIThreadPrint::countDown);
//
//                final int taskNumber = i + 1;
//                executorService.submit(() -> {
//                    System.out.println("Running task " + taskNumber + " in thread: " + Thread.currentThread().getName());
//                });
            }


        }
    }
}
