package com.mdt.FunctionalAndReactive.M21_CombiningObservables.M21_3_FlatAndConcat;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatMapConcatMap {

    public static void main(String[] args) {
        List<String> list = List.of("Hello", "Reactive", "Programming");
        var stringObservable = Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

        System.out.println("----------");

        var stringObservable2 = Observable.fromIterable(list)
                .concatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

        // todo: I don't get the difference between flatMap and concatMap
    }
}
