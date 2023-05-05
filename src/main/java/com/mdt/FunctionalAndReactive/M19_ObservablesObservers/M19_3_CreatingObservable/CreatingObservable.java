package com.mdt.FunctionalAndReactive.M19_ObservablesObservers.M19_3_CreatingObservable;

import io.reactivex.rxjava3.core.Observable;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CreatingObservable {
    public static void main(String[] args) {
        // create
        Observable<Integer> source = Observable.create(e -> {
            e.onNext(10);
            e.onNext(11);
            e.onNext(12);
            e.onComplete();
        });

        source.subscribe(System.out::println);

        // just
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        // fromIterable
        var list = List.of("Ram", "Shyam", "Mike");
        @NotNull
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);

        // range
        Observable.range(3, 10).subscribe(System.out::println);
    }
}
