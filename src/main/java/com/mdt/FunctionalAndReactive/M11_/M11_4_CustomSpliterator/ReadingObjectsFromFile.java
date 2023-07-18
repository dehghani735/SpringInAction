package com.mdt.FunctionalAndReactive.M11_.M11_4_CustomSpliterator;

import com.mdt.FunctionalAndReactive.M10_Streams.M10_2_Intro.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectsFromFile {

    public static void main(String[] args) {

        Path path = Paths.get("~/book.txt");
        try (Stream<String> lines = Files.lines(path);) {

            Spliterator<String> baseSpliterator = lines.spliterator();
            Spliterator<Book> bookSpliterator = new BookSpliterator(baseSpliterator);

            Stream<Book> stream = StreamSupport.stream(bookSpliterator, false);
            stream.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
