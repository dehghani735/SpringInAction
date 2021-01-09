package com.mdt.ocp.chapter7.SynchronizingDataAccess;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerCorrectSync {
    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        synchronized (this) {
            System.out.print(sheepCount.incrementAndGet() + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManagerCorrectSync manager = new SheepManagerCorrectSync();

            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
