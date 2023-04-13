package com.mdt.FunctionalAndReactive.M10_2_Intro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroduction {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        // after java 8

        var collect = books.parallelStream() //.stream().parallel()
                .filter(book -> book.getGenre().equalsIgnoreCase("horror"))
                .collect(Collectors.toList()); // we can collect data in any container

        books.add(new Book("the alchemist", "Paolo coelho", "Adventure", 4.40));
        books.add(new Book("the notebook", "2", "Romance", 4.1));
        books.add(new Book("Horror cocktail", "3", "Horror", 2.67));
        books.add(new Book("House of leaves", "4", "Horror", 4.10));

        var stream = books.stream();
        // streams are not containers
        var collect1 = stream
                .filter(book -> book.getGenre().equalsIgnoreCase("horror"))
                .collect(Collectors.toList()); // we can collect data in any container
        collect1.forEach(System.out::println);

        var collect2 = stream
                .filter(book -> book.getGenre().equalsIgnoreCase("Romance"))
                .collect(Collectors.toList()); // we can collect data in any container
        collect2.forEach(System.out::println);

    }
}
