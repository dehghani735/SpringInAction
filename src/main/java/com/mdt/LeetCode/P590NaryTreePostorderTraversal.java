package com.mdt.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Easy
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 * date: 6/9/22
 */
public class P590NaryTreePostorderTraversal {
    class Solution {
        /**
         * my solution
         *
         * @param root
         * @return
         */
        public List<Integer> postorder(Node root) {
            var arr = new ArrayList<Integer>();
            postorder(root, arr);

            return arr;
        }

        private void postorder(Node root, ArrayList<Integer> arr) {
            if (root == null)
                return;
            for (var child : root.children) {
                postorder(child, arr);
            }
            arr.add(root.val);
        }

        /**
         * Nick's solution
         *
         * @param root
         * @return
         */
        public List<Integer> postorder2(Node root) {
            var stack      = new LinkedList<Node>();
            var output_arr = new LinkedList<Integer>();

            if (root == null)
                return output_arr;

            stack.add(root);
            while (!stack.isEmpty()) {
                var node = stack.pollLast();
                output_arr.addFirst(node.val);
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
