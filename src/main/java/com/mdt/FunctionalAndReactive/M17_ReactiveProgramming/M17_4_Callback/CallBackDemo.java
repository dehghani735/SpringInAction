package com.mdt.FunctionalAndReactive.M17_ReactiveProgramming.M17_4_Callback;

public class CallBackDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread is running");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new CallBack() {

                    @Override
                    public void pushData(String data) {
                        System.out.println("CallBack data: " + data);
                    }

                    @Override
                    public void pushComplete() {
                        System.out.println("CallBack done !");
                    }

                    @Override
                    public void pushError(Exception ex) {
                        System.out.println("CallBack Error called, Got an Exception: " + ex);
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
        callBack.pushData("Data1");
        callBack.pushData("Data2");
        callBack.pushData("Data3");

        callBack.pushError(new RuntimeException("Oops!"));  // One of the pushComplete or pushError will be called in real scenarios.
        callBack.pushComplete();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
