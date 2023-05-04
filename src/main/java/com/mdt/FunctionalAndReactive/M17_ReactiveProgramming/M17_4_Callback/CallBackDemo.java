package com.mdt.FunctionalAndReactive.M17_ReactiveProgramming.M17_4_Callback;

public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread is running");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {
                    @Override
                    public void call() {
                        System.out.println("Callback called!");
                    }
                });
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(2000);

        System.out.println("Main thread completed!");
    }

    public void runningAsync(CallBack callBack) {
        System.out.println("I am running a separate thread");
        sleep(1000);
        callBack.call();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
