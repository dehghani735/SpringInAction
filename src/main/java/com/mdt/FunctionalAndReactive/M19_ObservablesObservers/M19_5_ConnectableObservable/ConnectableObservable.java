package com.mdt.FunctionalAndReactive.M19_ObservablesObservers.M19_5_ConnectableObservable;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ConnectableObservable {

    public static void main(String[] args) throws InterruptedException {

        io.reactivex.rxjava3.observables.ConnectableObservable<Long> source =
                Observable.interval(1, TimeUnit.SECONDS).publish();

        source.connect();
        source.subscribe(System.out::println);
        Thread.sleep(10000);
        source.subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
