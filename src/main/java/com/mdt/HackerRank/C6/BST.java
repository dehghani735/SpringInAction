package com.mdt.HackerRank.C6;

/**
 * validation of BST
 * <p>
 * solution one: using range and recursive
 */
public class BST {

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node root, int min, int max) { // inclusive ranges
        if (root == null)
            return true;
        if (root.data > max || root.data < min)
            return false;
        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }

    public static class Node {
        int  data;
        Node left;
        Node right;
    }
}
