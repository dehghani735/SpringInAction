package com.mdt.ocp.chapter7.SynchronizingDataAccess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerAtomic {
    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerAtomic manager = new SheepManagerAtomic();

            for (int i = 0; i < 100; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
