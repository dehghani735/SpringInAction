package com.mdt.FunctionalAndReactive.M18_RxJava;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(
                emitter -> {
                    emitter.onNext("Hello");
                    emitter.onNext("RxJava");
                }
        );
        source.subscribe(e -> System.out.println("Observer 1: " + e));
        source.subscribe(e -> System.out.println("Observer 2: " + e));
    }
}
