package com.mdt.FunctionalAndReactive.M22_Concurrency.M22_4_subscribeOn;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOn {

    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
                .subscribeOn(Schedulers.computation()) // computation will be executed, because it is closest to the source
                .map(e -> e.toUpperCase())
                .subscribeOn(Schedulers.newThread())
                .filter(e -> e.startsWith("P"))
                .subscribe(e -> print(e));

        Thread.sleep(6000);
    }

    public static void print(String element) {
        System.out.println(element + " : Printed By : " + Thread.currentThread().getName());
    }
}
