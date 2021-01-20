package com.mdt.ocp.Additionals;

import java.text.SimpleDateFormat;

public class Test1 {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();

        threadLocalValue.set(1);
        Integer result = threadLocalValue.get();

        System.out.println(result);

        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

        threadLocal.remove();

//        SimpleDateFormat
        //

    }
}
