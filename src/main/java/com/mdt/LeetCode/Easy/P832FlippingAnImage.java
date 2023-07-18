package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.
 * <p>
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * <p>
 * For example, inverting [0,1,1] results in [1,0,0].
 * <p>
 * date: 6/30/22
 */
public class P832FlippingAnImage {

    /**
     * Nick's solution has a trick idea. while left and right pointers have different values, skip. else invert them.
     * Idea: two pointer
     *
     * @param image
     * @return
     */
    public int[][] flipAndInvertImage(int[][] image) {

        for (var i = 0; i < image.length; i++) {
            var low  = 0;
            var high = image[i].length - 1;

            while (low <= high) {
                if (image[i][low] == image[i][high]) {
                    image[i][low]  = 1 - image[i][high]; // we can use xor instead.
                    image[i][high] = image[i][low];
                }

                low++;
                high--;
            }
        }
        return image;
    }
}
