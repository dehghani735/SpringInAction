package com.mdt.LeetCode.Medium;

public class P665NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (idx != 0) return false;
                idx = i;
            }
        }

        if (idx == 0 || idx == 1 || idx == n - 1) return true;
        if ((nums[idx - 1] > nums[idx + 1]) && (nums[idx - 2] > nums[idx])) return false;
        return true;
    }
}
