package com.mdt.LeetCode.Easy;

import com.mdt.LeetCode.Easy.P226InvertBinaryTree.TreeNode;

/**
 * Easy
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 * <p>
 * date: 7/08/22
 */
public class P108ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if (left > right) return null; // This base cases is very important
        var middle   = left + (right - left) / 2; // important formula to find middle element  in an array // avoids integer overflow
        var treeNode = new TreeNode(nums[middle]);
        treeNode.left  = constructTreeFromArray(nums, left, middle - 1);
        treeNode.right = constructTreeFromArray(nums, middle + 1, right);

        return treeNode;
    }
}
