package com.mdt.FunctionalAndReactive.M22_Concurrency.M22_5_observeOn;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toUpperCase())
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .filter(e -> e.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(e -> print(e));

        // it will cause producer consumer problem due to the speed of producer, the solution is flowable to support
        // back pressure. It will be discussed in next sections.

        Thread.sleep(6000);
    }

    public static void print(String element) {
        System.out.println(element + " : Printed By : " + Thread.currentThread().getName());
    }
}
