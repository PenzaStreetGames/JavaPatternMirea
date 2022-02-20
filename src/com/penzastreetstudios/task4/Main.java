package com.penzastreetstudios.task4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<Callable<String>> tasks = new LinkedList<>();
        for(long i = 1; i < 9; i++) {
            long finalI = i;
            tasks.add(() -> {
               double res = 0;
               for (long j = 1; j < Math.pow(10, finalI); j++) {
                   res += 1.0 / j;
               }
               return "Sum of 1/n (10e"+ finalI + " iterations) = " + res;
            });
        }
        MyExecutorService myService = new MyExecutorService(5);
        try {
            List<Future<String>> results = myService.invokeAll(tasks);
            for(Future<String> result : results) {
                myService.execute(() ->
                {
                    try {
                        System.out.println(result.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myService.shutdown();
    }
}
