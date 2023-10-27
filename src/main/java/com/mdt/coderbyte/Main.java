package com.mdt.coderbyte;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {

    public static String StringChallenge(String str) {

        String[] result = str.split(" ");
        String res = "-1";
        int max = 1;
        Map<Character, Integer> count = new HashMap<>();

        for (int j = 0; j < result.length; j++) {

            count.clear();
            for (int i = 0; i < result[j].length(); i++) {
                Character c = result[j].charAt(i);
                Integer integer = count.get(c);
                if (integer == null)
                    count.put(c, 1);
                else {
                    if (integer + 1 > max) {
                        max = integer + 1;
                        res = result[j];
                    }
                    count.put(c, integer + 1);


                }
//                count.compute(c, (character, integer) -> {
//                    if (integer == null)
//                        return 1;
//                    else {
//                        if (integer + 1 > max) {
//                            max = integer + 1;
//                            res.set(s);
//                        }
//                        return integer + 1;
//
//                    }
//                });
            }

        }
//        Arrays.stream(result).forEach(
//                s -> {
//                    count.clear();
//                    for (int i = 0; i < s.length(); i++) {
//                        Character c = s.charAt(i);
//                        count.compute(c, (character, integer) -> {
//                            if (integer == null)
//                                return 1;
//                            else {
//                                if (integer + 1 > max.get()) {
//                                    max.set(integer + 1);
//                                    res.set(s);
//                                }
//                                return integer + 1;
//
//                            }
//                        });
//                    }
//                });


        return res;
    }




    public static int ArrayChallenge(int[] arr) {
        int result = -1;
        boolean increasing = arr[0] < arr[1] ? true : false;
        for (int i = 2; i < arr.length; i++) {
            if (increasing) {
                if (arr[i] < arr[i - 1])  {
                    result = i - 1;
                    break;
                }

            } else {

                if (arr[i] > arr[i - 1])  {
                    result = i - 1;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        set.add(null);
//

//        Scanner s = new Scanner(System.in);
//        System.out.println(StringChallenge(s.nextLine()));

//        Scanner s = new Scanner(System.in);
//        System.out.println(ArrayChallenge(s.nextLine()));

        String result = SearchingChallenge("(c(oder)) b(yte)");
        System.out.println(result);

    }
    public static String SearchingChallenge(String str) {

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push('(');
            else if (str.charAt(i) == ')') {
                if (stack.isEmpty())
                    return "0";
                stack.pop();
            }
        }

        if (!stack.isEmpty())
            return "0";

        else return "1";
    }
}