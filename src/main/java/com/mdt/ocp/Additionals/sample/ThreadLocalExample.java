package com.mdt.ocp.Additionals.sample;

//  http://tutorials.jenkov.com/java-concurrency/threadlocal.html
public class ThreadLocalExample {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate


    }
}
