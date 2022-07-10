package com.mdt.LeetCode.Easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Easy
 * <p>
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * date: 7/08/22
 */
public class P559MaximumDepthOfNaryTree {

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

    /**
     * my solution
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        var children = root.children;
        var max      = 1;
        for (var child : children) {
            max = Math.max(max, 1 + maxDepth(child));
        }
        return max;
    }

    /**
     * Nick's solution using BFS
     *
     * @param root
     * @return
     */
    public int maxDepth2(Node root) {
        if (root == null)
            return 0;

        var depth = 0;
        var queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var size = queue.size();

            for (var i = 0; i < size; i++) { // this loop is important
                var currentNode = queue.poll();
                for (var child : currentNode.children)
                    queue.offer(child);
            }

            depth++;
        }
        return depth;
    }
}
