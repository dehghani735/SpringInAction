package com.mdt.LeetCode.Medium;

/**
 * Medium
 * <p>
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * date: 7/25/22
 */
public class P11ContainerWithMostWater {

    /**
     * Nick's solution
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        var maxArea  = 0;
        var aPointer = 0;
        var bPointer = height.length - 1;

        while (aPointer < bPointer) {
            if (height[aPointer] < height[bPointer]) {
                maxArea = Math.max(maxArea, height[aPointer] * (bPointer - aPointer));
                aPointer++;
            } else {
                maxArea = Math.max(maxArea, height[bPointer] * (bPointer - aPointer));
                bPointer--;
            }
        }

        return maxArea;
    }
}
