package com.mdt.LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Easy
 * <p>
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * date: 6/9/22
 */
public class P589NaryTreePreorderTraversal {
    class Solution {

        /**
         * my solution
         *
         * @param root
         * @return
         */
        public List<Integer> preorder(Node root) {
            var arr = new ArrayList<Integer>();
            preorder(root, arr);

            return arr;
        }

        private void preorder(Node root, ArrayList<Integer> arr) {
            if (root == null)
                return;
            arr.add(root.val);
            for (var child : root.children) {
                preorder(child, arr);
            }
        }

        /**
         * TODO review and try to understand
         */
        public List<Integer> preorder2(Node root) {
            var stack      = new LinkedList<Node>();
            var output_arr = new LinkedList<Integer>();

            if (root == null)
                return output_arr;

            stack.add(root);
            while (!stack.isEmpty()) {
                var node = stack.pollLast();
                output_arr.add(node.val);
                Collections.reverse(node.children);
                for (var child : node.children) {
                    stack.add(child);
                }
            }
            return output_arr;
        }
    }

    class Node {
        public int        val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val      = _val;
            children = _children;
        }
    }
}
