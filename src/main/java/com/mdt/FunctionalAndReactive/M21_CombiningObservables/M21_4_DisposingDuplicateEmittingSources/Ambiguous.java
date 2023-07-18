package com.mdt.FunctionalAndReactive.M21_CombiningObservables.M21_4_DisposingDuplicateEmittingSources;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ambiguous {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS).take(10)
                .map(e -> "Ob 1 :" + e);
        Observable<String> ob2 = Observable.interval(10, TimeUnit.MILLISECONDS).take(10)
                .map(e -> "Ob 2 :" + e); // is the faster one

        Observable.amb(Arrays.asList(ob1, ob2))
                .subscribe(System.out::println); // amb will emit only ob2 because it's faster
        // amb will use parallel processing to decide which one to execute first

        Thread.sleep(10000);
    }
}
