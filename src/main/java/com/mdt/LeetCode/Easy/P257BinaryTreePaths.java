package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * <p>
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * date: 7/09/22
 */
public class P257BinaryTreePaths {

    /**
     * my solution
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(P226InvertBinaryTree.TreeNode root) {
        var result = new ArrayList<String>();
        if (root == null)
            return result;
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        result.addAll(binaryTreePaths(root.left).stream().map(it -> root.val + "->" + it).toList());
        result.addAll(binaryTreePaths(root.right).stream().map(it -> root.val + "->" + it).toList());

        return result;
    }

    public static void main(String[] args) {
        var problem = new P257BinaryTreePaths();
        System.out.println(problem.binaryTreePaths(new P226InvertBinaryTree.TreeNode(4, new P226InvertBinaryTree.TreeNode(5), new P226InvertBinaryTree.TreeNode(6))));
    }
}
