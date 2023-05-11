package com.mdt.FunctionalAndReactive.M21_CombiningObservables.M21_6_Grouping;

import com.mdt.FunctionalAndReactive.M20_RxJavaOperators.M20_Operators.M20_4_Action.Employee;
import io.reactivex.rxjava3.core.Observable;

public class Grouping {

    public static void main(String[] args) {

        Observable<Employee> obs = Observable.just(
                new Employee(101, "Alexa", 60000, 4.0),
                new Employee(123, "Dhwanit", 60000, 4.7),
                new Employee(236, "Mike", 60000, 4.0),
                new Employee(155, "Ella", 60000, 4.4),
                new Employee(443, "George", 60000, 3.6),
                new Employee(127, "Shreeja", 60000, 4.5),
                new Employee(509, "Daniel", 60000, 4.0),
                new Employee(344, "Lucy", 60000, 4.7),
                new Employee(509, "Harry", 60000, 4.3),
                new Employee(344, "Emma", 60000, 3.7)
        );

        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), Employee::getName))
                .subscribe(System.out::println);

        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toList())
                .subscribe(System.out::println);
    }
}
