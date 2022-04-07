package com.mdt.CrackingInterview.Chapter1;

public class Q4 {
    public static void main(String[] args) {

        int number = 9;
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.bitCount(number));
        System.out.println(Integer.toHexString(number));
        System.out.println(Integer.parseInt(((Integer)number).toString(), 8));
    }
}
