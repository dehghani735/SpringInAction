package com.mdt.ocp.chapter7.ThreadsWithExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
    public static void main(String[] args) {
        // Let’s start with a simple example using the newSingleThreadExecutor() method to obtain
        //an ExecutorService instance and the execute() method to perform asynchronous tasks:
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                    for (int i = 0; i < 3; i++)
                        System.out.println("Printing record: " + i);
                }
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
