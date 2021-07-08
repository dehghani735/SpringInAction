package com.mdt.ocp.chapter8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Serializable
//        String

//        CompletableFuture

//        Future<String> completableFuture =
//                CompletableFuture.completedFuture("Hello");
//// ...
//        String result = completableFuture.get();
//        System.out.println(result);
//        //
//        CompletableFuture<String> future
//                = CompletableFuture.supplyAsync(() -> "Hello");
//// ...
//        System.out.println(future.get());

        //
//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello");
//
//        CompletableFuture<String> future = completableFuture
//                .thenApply(s -> s + " World");
//
////        assertEquals("Hello World", );
//        System.out.println(future.get());


//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello");
//
//        CompletableFuture<Void> future = completableFuture
//                .thenAccept(s -> System.out.println("Computation returned: " + s));
//
//        System.out.println(future.get());


//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello");
//
//        CompletableFuture<Void> future = completableFuture
//                .thenRun(() -> System.out.println("Computation finished."));
//
//        System.out.println(future.get());


//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
//        // The argument of this function is the result of the previous computation step
//        // This allows us to use this value inside the next CompletableFuture‘s lambda:
//
//        // The thenCompose method, together with thenApply, implement basic building blocks of the monadic pattern.
//        // They closely relate to the map and flatMap methods of Stream and Optional classes also available in Java 8.
//
//        System.out.println(completableFuture.get());

        //
//        CompletableFuture<String> completableFuture
//                = CompletableFuture.supplyAsync(() -> "Hello")
//                .thenCombine(CompletableFuture.supplyAsync(
//                        () -> " World"), (s1, s2) -> s1 + s2);
//
//        System.out.println(completableFuture.get());
        //        assertEquals("Hello World", completableFuture.get());

        CompletableFuture<String> future1
            = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
            = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
            = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
            = CompletableFuture.allOf(future1, future2, future3);

// ...

        System.out.println(combinedFuture.get()); // does not return the combined results of all Futures

        System.out.println(future1.isDone() + " " + future2.isDone() + " " + future3.isDone());

        String combined = Stream.of(future1, future2, future3)
            .map(CompletableFuture::join)
            .collect(Collectors.joining(" "));
        System.out.println(combined);


        String name = null;
// ...
        CompletableFuture<String> completableFuture
            = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger! " + t);

        System.out.println(completableFuture.get());

        // Async Methods
        //Most methods of the fluent API in CompletableFuture class have two additional variants with the Async postfix.
        // These methods are usually intended for running a corresponding step of execution in another thread.

        CompletableFuture<String> completableFuture2
            = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture2
            .thenApplyAsync(s -> s + " World");

        System.out.println(future.get());
    }
}
