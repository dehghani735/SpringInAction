package com.mdt.FunctionalAndReactive.M22_Concurrency.M22_3_Schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.single());

        src.subscribe(e -> sensitiveTask(e));
        src.subscribe(e -> sensitiveTask(e));
        src.subscribe(e -> sensitiveTask(e));
        src.subscribe(e -> sensitiveTask(e));
        src.subscribe(e -> sensitiveTask(e));

        Thread.sleep(50000);
    }

    public static void sensitiveTask(String obj) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(obj + " Computation done by : " + Thread.currentThread().getName());
    }
}
