package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * date: 6/9/22
 */
public class P226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        var left  = root.left;
        var right = root.right;

        root.left  = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

    static class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode()        {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val   = val;
            this.left  = left;
            this.right = right;
        }
    }
}
