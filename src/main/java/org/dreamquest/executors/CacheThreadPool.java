package org.dreamquest.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CacheThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Future<Integer>> futures;
        try (ExecutorService executorService = Executors.newCachedThreadPool(new CustomThreadName())) {

            List<Callable<Integer>> summation = List.of(

                    () -> CacheThreadPool.add(10, 100, 10, Thread.currentThread().getName()),
                    () -> CacheThreadPool.add(2, 10, 2,Thread.currentThread().getName()),

                    () -> CacheThreadPool.add(100, 1000, 100, Thread.currentThread().getName()),
                    () -> CacheThreadPool.add(50, 100, 5, Thread.currentThread().getName())
            );

            futures = executorService.invokeAll(summation);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Future<Integer> future : futures) {

            System.out.println(future.get());
        }

    }

    public static int add(int start, int end, int delta, String threadColor)
    {
        int sum = 0;

        ThreadColor color = ThreadColor.ANSI_RESET;

        color = ThreadColor.valueOf("ANSI_"+threadColor);
        for(int i = start; i <= end ; i+= delta)
        {
            sum =  sum+i;
        }

        System.out.printf("%s%s %d%n", color.getColor(), Thread.currentThread().getName(), sum);
        return sum;
    }
}
