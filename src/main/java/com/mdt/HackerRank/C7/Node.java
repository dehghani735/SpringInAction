package com.mdt.HackerRank.C7;

/**
 * BST functions
 */
public class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    /**
     * it's recursive
     */
    public void insert(int value) {
        if (value <= data) {
            if (left == null)
                left = new Node(value);
            else
                left.insert(value);
        } else {
            if (right == null)
                right = new Node(value);
            else
                right.insert(value);
        }
    }

    /**
     * it's recursive
     */
    public boolean contains(int value) {
        if (value == data)
            return true;
        else if (value < data) {
            if (left == null)
                return false;
            else
                return left.contains(value);
        } else {
            if (right == null)
                return false;
            else
                return right.contains(value);
        }
    }

    /**
     * InOrder: root is in middle
     * pre: root is first
     * post: root is last
     */
    public void printInOrder() {
        if (left != null)
            left.printInOrder();
        System.out.println(data);
        if (right != null)
            right.printInOrder();
    }
}
