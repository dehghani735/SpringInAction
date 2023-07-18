package com.mdt.FunctionalAndReactive.M19_ObservablesObservers.M19_7_Disposing;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Disposing {

    private static final CompositeDisposable disp = new CompositeDisposable();

    public static void main(String[] args) throws InterruptedException {

        @NonNull Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

        Disposable d1 = source.subscribe(e -> System.out.println("Observer 1: " + e));
        Disposable d2 = source.subscribe(e -> System.out.println("Observer 2: " + e));

//        source.subscribe(e -> System.out.println("Observer 1: " + e)).dispose();
//        @NotNull
//        Disposable d = source.subscribe(e -> System.out.println("Observer 1: " + e));
//
        Thread.sleep(5000);
        disp.addAll(d1, d2);
        disp.dispose();

        Thread.sleep(10000);
    }
}
