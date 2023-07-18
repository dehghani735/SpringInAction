package com.mdt.FunctionalAndReactive.M17_ReactiveProgramming.M17_6_Observer;

public class ObserverDesignPattern {

    public static void main(String[] args) throws InterruptedException {

        Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "Sold out");

        EndUser user1 = new EndUser("Bob", book);
        EndUser user2 = new EndUser("Rob", book);

        System.out.println(book.getInStock());

        book.setInStock("In Stock");
    }
}
