package com.mdt.FunctionalAndReactive.M8_12_Closures;

public class JavaClosure {

    public static void main(String[] args) {
        int val = 111; // the free variable

        // we are not calling this lambda within its own scope
        // JRE is keeping track of val value over here
        Task lambda = () -> {
            System.out.println(val);
            System.out.println("Task Completed.");
        }; // this is the closure which is using the free variable present in its lexical scope.

        // this is this method that is executing this lambda
        // When we pass this lambda to printValue, the value of val is also passed. Where the value is coming from? it's coming from the closure.
        // Wherever any lambda expression uses a free variable in the same scope, the value of that variable is saved. and whenever we call the lambda,
        // it goes along with that; and that's what a closure is.
        printValue(lambda);
    }

    // the val variable is not in this scope.
    private static void printValue(Task lambda) {
        lambda.doTask();
    }
}
