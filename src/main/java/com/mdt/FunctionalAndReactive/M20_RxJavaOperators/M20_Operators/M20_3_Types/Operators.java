package com.mdt.FunctionalAndReactive.M20_RxJavaOperators.M20_Operators.M20_3_Types;

import io.reactivex.rxjava3.core.Observable;

public class Operators {
    public static void main(String[] args) {

        Observable.just(60, 57, 89, 90, 23, 100, 98)
                .filter(e -> e > 75)
                .sorted()
                .subscribe(e -> System.out.println("Grade A with " + e));
    }
}
