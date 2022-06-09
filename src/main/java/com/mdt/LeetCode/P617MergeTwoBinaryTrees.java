package com.mdt.LeetCode;

/**
 * Easy
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * date: 6/9/22
 */
public class P617MergeTwoBinaryTrees {

    /**
     * my solution, I create a whole new tree
     */
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null)
                return null;

            var firstNull  = root1 == null;
            var secondNull = root2 == null;

            var newVal = root1 != null ? root1.val : 0;
            newVal += root2 != null ? root2.val : 0;

            return new TreeNode(newVal, mergeTrees(firstNull ? null : root1.left, secondNull ? null : root2.left),
                    mergeTrees(firstNull ? null : root1.right, secondNull ? null : root2.right));
        }

        /**
         * nick's solution, overwrite one of them
         *
         * @param root1
         * @param root2
         * @return
         */
        public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
            if (root1 == null)
                return root2;
            if (root2 == null)
                return root1;

            root1.val += root2.val;
            root1.left  = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
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
