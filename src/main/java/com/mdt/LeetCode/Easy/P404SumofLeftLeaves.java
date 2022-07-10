package com.mdt.LeetCode.Easy;

import java.util.Stack;

/**
 * Easy
 * <p>
 * Given the root of a binary tree, return the sum of all left leaves.
 * <p>
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * date: 6/13/22
 */
public class P404SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        var sumOfLeft = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                sumOfLeft += root.left.val;
            else
                sumOfLeft += sumOfLeftLeaves(root.left);
        }

        if (root.right != null) {
            if (root.right.left != null || root.right.right != null)
                sumOfLeft += sumOfLeftLeaves(root.right);
        }
        return sumOfLeft;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null)
            return 0;

        var sumOfLeft = 0;
        var stack     = new Stack<TreeNode>();
        stack.add(root);

        while (!stack.isEmpty()) {
            var  node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null)
                    sumOfLeft += node.left.val;
                else
                    stack.add(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null)
                    stack.add(node.right);
            }
        }
        return sumOfLeft;
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
