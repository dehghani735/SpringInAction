package com.mdt.FunctionalAndReactive.M22_Concurrency.M22_3_Schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(executorService);

        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(scheduler)
                .doFinally(executorService::shutdown); // if we don't do that, program will not be terminated.

        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by : " + Thread.currentThread().getName());
    }
}
