package com.mdt.FunctionalAndReactive.M22_Concurrency.M22_2_HowTo;

import io.reactivex.rxjava3.core.Observable;

public class ConcurrencyInRxJava {

    public static void main(String[] args) {

        Observable<String> source = Observable.create(
                emitter -> new Thread(() -> {
                    emitter.onNext("Hello");
                    emitter.onNext("RxJava");
                }).start()
        );

        source.subscribe(e -> System.out.println("Observer 1: " + e + " Thread is : " + Thread.currentThread().getName()));
        source.subscribe(e -> System.out.println("Observer 2: " + e + " Thread is : " + Thread.currentThread().getName()));


    }
}
