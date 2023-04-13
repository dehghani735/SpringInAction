package com.mdt.FunctionalAndReactive.M10_10_NumericStreams;

import com.mdt.FunctionalAndReactive.M10_2_Intro.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreams {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        // after java 8

        books.add(new Book("the alchemist", "Paolo coelho", "Adventure", 4.40));
        books.add(new Book("the notebook", "2", "Romance", 4.1));
        books.add(new Book("Horror cocktail", "3", "Horror", 2.67));
        books.add(new Book("House of leaves", "4", "Horror", 4.10));

        OptionalDouble average = books.stream()
                .mapToDouble(book -> book.getRating())
                .average();// average is only available on stream of numbers

        System.out.println(average.getAsDouble());

        // map: Objects
        // mapToDouble: primitive double

        IntStream intS = IntStream.of(1, 3, 5, 7);
        DoubleStream doubleS = DoubleStream.of(1, 3, 5, 7);
        LongStream longS = LongStream.of(1L, 3L, 5L, 7L);

        // to reverse it to Objects
        // 1st way
        Stream<Integer> boxedInts = intS.boxed();
        // 2nd way
        Stream<Double> doubleStream = doubleS.mapToObj(val -> val);
    }
}
