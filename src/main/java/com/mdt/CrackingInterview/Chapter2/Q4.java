package com.mdt.CrackingInterview.Chapter2;

import java.util.LinkedList;

/**
 * @author MDT
 */
public class Q4 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.addLast();
        System.out.println(Integer.BYTES);
        int n = 5;
        System.out.println(((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1));
    }
}
