package com.mdt.HackerRank.Algorithm.C2;

import java.util.Arrays;

public class Solution {

    /**
     * finds the indices of two items on the menu that allow us to spend all our money
     * @param menu
     * @param money
     * @return
     */
    public static int[] findChoices(int[] menu, int money) {
        var sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            var complement = money - sortedMenu[i];
            var location   = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                var indices = getIndicesFromValues(menu, sortedMenu[i], complement);
                return indices;
            }
        }
        return null;
    }

    private static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        var index1  = indexOf(menu, value1, -1);
        var index2  = indexOf(menu, value2, index1);
        var indices = new int[]{Math.min(index2, index1), Math.max(index2, index1)};
        return indices;
    }

    private static int indexOf(int[] menu, int value, int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != excludeThis)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
