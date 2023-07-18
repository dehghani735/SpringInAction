package com.mdt.FunctionalAndReactive.M22_Concurrency.M22_3_Schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {

    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.newThread());

        src.subscribe(e -> task(e));
        Thread.sleep(6000); //  thread 1 is done after this
        src.subscribe(e -> task(e));
        src.subscribe(e -> task(e));
        src.subscribe(e -> task(e));
        src.subscribe(e -> task(e));

        Thread.sleep(50000);
    }

    public static void task(String obj) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(obj + " Computation done by : " + Thread.currentThread().getName());
    }
}
