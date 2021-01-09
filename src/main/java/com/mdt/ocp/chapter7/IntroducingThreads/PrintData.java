package com.mdt.ocp.chapter7.IntroducingThreads;

public class PrintData implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Printing Record: " + i);
        }
    }

    public static void main(String[] args) {
        (new Thread(new PrintData())).start();
    }
}