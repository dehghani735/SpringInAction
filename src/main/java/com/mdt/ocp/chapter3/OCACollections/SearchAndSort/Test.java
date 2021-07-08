package com.mdt.ocp.chapter3.OCACollections.SearchAndSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {6, 9, 1, 8};
        Arrays.sort(numbers); // {1, 6, 8, 9}
        System.out.println(Arrays.binarySearch(numbers, 6));
        System.out.println(Arrays.binarySearch(numbers, 1));

        // The number 3 would need to be inserted at index 1 (after the number 1 but before the number 6). Negating
        // that gives us -1 and subtracting 1 gives us -2.
        System.out.println(Arrays.binarySearch(numbers, 3));

        List<Integer> list = Arrays.asList(9, 7, 5, 3);
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, 3));
        System.out.println(Collections.binarySearch(list, 2));

        list.remove(1); // recall that we can not remove from list backed with array (UnsupportedOperationException)
    }
}
