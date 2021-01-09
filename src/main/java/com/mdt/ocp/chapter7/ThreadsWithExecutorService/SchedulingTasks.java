package com.mdt.ocp.chapter7.ThreadsWithExecutorService;

import java.util.concurrent.*;

public class SchedulingTasks {
    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            Runnable task1 = () -> System.out.println("Hello Zoo");
            Callable<String> task2 = () -> "Monkey";
            Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
            Future<?> result2 = service.schedule(task2, 8, TimeUnit.SECONDS);
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
