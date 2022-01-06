package com.mdt.CrackingInterview.bigO;

public class Example12 {

    void permutation(String str) {
        permutation(str, "");
    }

    private void permutation(String str, String prefix) {
        if (str.length() == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < str.length(); i++) {
                var rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        var exp = new Example12();
        exp.permutation("reza");
    }
}
