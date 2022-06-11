package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * A binary tree is uni-valued if every node in the tree has the same value.
 * <p>
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 * <p>
 * date: 6/11/22
 */
public class P965UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;

        var leftUnival = true;
        if (root.left != null) {
            if (root.left.val == root.val) {
                leftUnival = isUnivalTree(root.left);
            } else
                return false;
        }
        var rightUnival = true;
        if (root.right != null) {
            if (root.right.val == root.val) {
                rightUnival = isUnivalTree(root.right);
            } else
                return false;
        }
        return leftUnival && rightUnival;
    }

    class TreeNode {
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
