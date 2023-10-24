package com.mdt.codality;

import java.util.*;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
//        var test = new Test();
//        var arr = new int[]{5, 3, 6, 1, 3};
//        var arr2 = new int[]{3, 5, 1, 3, 9, 8};
////        var result = test.solution(arr, 2);
//        var result = test.solution(arr2, 4);
//
//        System.out.println(result);

        System.out.println(-1 % 24);
        var p = new Test();
        p.solution("12:01", "12:44");


//        boolean b1 = true, b2 = false; int i1 = 1, i2 = 2;
//        System.out.println(i2 && b1);

//        int array[] = {1, 2, 3, 4};
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//        }


        var a = new Object[][]{{"Fred", "Jim", "Sheila"}, {1, 2}};
        var b = new Object[][]{{"Fred", "Jim", "Sheila"}, {1, 2}};

        System.out.println(Arrays.equals(a, b));

//        Arrays.copyOf();

        // hangs
//        new Random().doubles(-1.0, 1.0)
//                .average()
//                .ifPresent(System.out::println);


        Stream.of("Fred", "Jim", "Sheila")
//                .flatMapToInt(s -> s.chars())
                .map(s -> s.chars())
                .forEach(System.out::println);
    }

    public String solution(String[] A, String[] B, String P) {
        // Implement your solution here

        Map<String, String> hashMap = new HashMap<>();
        for (var i = 0; i < A.length; i++) {
            hashMap.put(A[i], B[i]);
        }

        var result = hashMap.entrySet().stream()
                .filter(entry -> entry.getValue().contains(P))
                .sorted(Comparator.comparing(entry -> entry.getKey()))
                .findFirst();

        if (result.isPresent())
            return result.get().getKey();

        else return "NO CONTACT";

//        Arrays.stream(B)
//                .allMatch(phone -> {
//                    return phone.contains(P);
//                });


    }

    public int solution(String A, String B) {
        // Implement your solution here

        // Implement your solution here
        // Implement your solution here
        if (A.equals(B)) return 0;
        int counter = 0;

        var Ahour = Integer.parseInt(A.substring(0, 2));
        var Aminute = Integer.parseInt(A.substring(3));
        var Bhour = Integer.parseInt(B.substring(0, 2));
        var Bminute = Integer.parseInt(B.substring(3));


        if (Aminute == 0) counter = 4;
        if (Aminute == 15) counter = 3;
        if (Aminute == 30) counter = 2;
        if (Aminute == 45) counter = 1;
        else {
            if (Aminute > 0 && Aminute < 15) Aminute = 15;
            if (Aminute > 15 && Aminute < 30) Aminute = 30;
            if (Aminute > 30 && Aminute < 45) Aminute = 45;
            if (Aminute > 45 && Aminute <= 59) Aminute = 0;

            if (Aminute == 0) counter = 0;
            if (Aminute == 15) counter = 3;
            if (Aminute == 30) counter = 2;
            if (Aminute == 45) counter = 1;
        }

        if (Bminute == 0) counter += 0;
        if (Bminute == 15) counter += 1;
        if (Bminute == 30) counter += 2;
        if (Bminute == 45) counter += 3;
        else {
            if (Bminute > 0 && Bminute < 15) Bminute = 0;
            if (Bminute > 15 && Bminute < 30) Bminute = 15;
            if (Bminute > 30 && Bminute < 45) Bminute = 30;
            if (Bminute > 45 && Bminute <= 59) Bminute = 45;

            if (Bminute == 0) counter += 0;
            if (Bminute == 15) counter += 1;
            if (Bminute == 30) counter += 2;
            if (Bminute == 45) counter += 3;
        }

        if (Ahour == Bhour)
            return (Bminute - Aminute) / 15;

        Ahour = (Ahour + 1) % 24;

        int diff = 0;
        if (Bhour > Ahour) {
            diff = Bhour - Ahour;
        } else if (Bhour < Ahour) {
            diff = (24 - Ahour) + Bhour;
        }
        counter += ((diff + 1) * 4);

        return counter;
    }

    public int solution(int[] blocks) {
        // Implement your solution here
        var arr = new int[blocks.length];

        for (var i = 0; i < blocks.length; ++i) {
            int j = i;
            while (j + 1 < blocks.length) {
                if (blocks[j + 1] < blocks[j])
                    break;
                j++;
            }
            int k = i;
            while (k - 1 >= 0) {
                if (blocks[k - 1] < blocks[k])
                    break;
                --k;
            }
            arr[i] = (j - k) + 1;
        }
        return Arrays.stream(arr).max().getAsInt();
    }

    public int solution(int[] A, int k) {
        int[][] left = new int[A.length][2];
        int leftMin = A[0];
        int leftMax = A[0];
        left[0][0] = Integer.MAX_VALUE;
        left[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            left[i][0] = leftMin;
            left[i][1] = leftMax;
            leftMin = Math.min(leftMin, A[i]);
            leftMax = Math.max(leftMax, A[i]);
        }
        int[][] right = new int[A.length][2];
        int rightMin = A[A.length - 1];
        int rightMax = A[A.length - 1];
        right[A.length - 1][0] = Integer.MAX_VALUE;
        right[A.length - 1][1] = Integer.MIN_VALUE;
        for (int i = A.length - 2; i >= 0; i--) {
            right[i][0] = rightMin;
            right[i][1] = rightMax;
            rightMin = Math.min(rightMin, A[i]);
            rightMax = Math.max(rightMax, A[i]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= A.length - k; i++) {
            int min = Math.min(left[i][0], right[i + k - 1
                    ][0]);
            int max = Math.max(left[i][1], right[i + k -
                    1][1]);
            res = Math.min(res, max - min);
        }
        return res;
    }

//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
//        String[] arr = new String[] {"co", "dil", "ity"};
//        int res = solution(arr);
//        System.out.println(res);
//    }

//    public static int solution(String[] A) {
//
//        List<Set<Character>> dp = new ArrayList<>();
//        for (var x : A) {
//            Set<Character> setX = new HashSet<>(x.toCharArray());
//            if (setX.size() == x.length()) {
//                dp.add(setX);
//            }
//        }
//        for (String v : A) {
//            Set<String> a = new HashSet<>(Arrays.asList(v));
//            if (a.size() == v.length()) {
//                for (Set<String> b : dp) {
//                    if (!Collections.disjoint(a, b)) {
//                        continue;
//                    }
//                    dp.add(new HashSet<>(a));
//                }
//            }
//        }
//        for (String x : A) {
//            Set<String> tmp = new HashSet<>(Arrays.asList(x));
//            if (dp.contains(tmp)) {
//                dp.remove(tmp);
//            }
//        }
//        int maxLen = 0;
//        for (Set<String> x : dp) {
//            maxLen = Math.max(maxLen, x.size());
//        }
//        return maxLen;
//    }
}
