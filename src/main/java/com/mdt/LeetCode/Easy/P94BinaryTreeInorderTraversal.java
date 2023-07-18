package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Easy
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * date: 7/22/22
 */
public class P94BinaryTreeInorderTraversal {

    /**
     * Nick's solution
     * idea: using stack and iterative approach
     * space complexity is O(log N) I think
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(P700SearchinaBinarySearchTree.TreeNode root) {
        var stack  = new Stack<P700SearchinaBinarySearchTree.TreeNode>();
        var result = new ArrayList<Integer>();
        if (root == null)
            return result;
        var current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

    /**
     * Leetcode's solution
     * idea: iterative
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(P700SearchinaBinarySearchTree.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(P700SearchinaBinarySearchTree.TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }

    /**
     * leetcode's solution
     * idea: Morris Traversal
     *
     * In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:
     *
     *     Step 1: Initialize current as root
     *
     *     Step 2: While current is not NULL,
     *
     *     If current does not have left child
     *
     *         a. Add current’s value
     *
     *         b. Go to the right, i.e., current = current.right
     *
     *     Else
     *
     *         a. In current's left subtree, make current the right child of the rightmost node
     *
     *         b. Go to this left child, i.e., current = current.left
     *
     *  Space complexity: O(1)
     *
     *  TODO: try to understand next time
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(P700SearchinaBinarySearchTree.TreeNode root) {
        List<Integer>                          res  = new ArrayList<>();
        var                                    curr = root;
        P700SearchinaBinarySearchTree.TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                var temp = curr; // store cur node
                curr      = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}
