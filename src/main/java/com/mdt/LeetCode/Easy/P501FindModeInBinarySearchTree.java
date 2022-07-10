package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * <p>
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 * <p>
 * If the tree has more than one mode, return them in any order.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * date: 7/09/22
 */
public class P501FindModeInBinarySearchTree {

    Integer prev  = null; // nice way to check a variable to identify it is not set before
    int     count = 1;
    int     max   = 0;

    /**
     * Nick's solution. TODO needs review
     * @param root
     * @return
     */
    public int[] findMode(P226InvertBinaryTree.TreeNode root) {
        List<Integer> modes = new ArrayList<Integer>();

        traverse(root, modes);

        var result = new int[modes.size()];
        for (var i = 0; i < modes.size(); i++)
             result[i] = modes.get(i);

        return result;
    }

    public void traverse(P226InvertBinaryTree.TreeNode node, List<Integer> modes) {
        if (node == null) return;

        traverse(node.left, modes);

        if (prev != null) {
            if (prev == node.val)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            modes.clear();
            modes.add(node.val);
        } else if (count == max)
            modes.add(node.val);

        prev = node.val;

        traverse(node.right, modes);
    }
}
