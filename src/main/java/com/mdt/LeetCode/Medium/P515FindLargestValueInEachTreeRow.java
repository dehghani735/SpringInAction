package com.mdt.LeetCode.Medium;

import com.mdt.LeetCode.Easy.P226InvertBinaryTree.TreeNode;

import java.util.*;

/**
 * Medium
 * <p>
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 * <p>
 * date: 10/14/22
 */
public class P515FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        var largestValue = new ArrayList<Integer>();

        if (!queue.isEmpty())
            largestValue.add(root.val);

        while (!queue.isEmpty()) {
            var size = queue.size();

            for (var i = 0; i < size; i++) {
                var currentNode = queue.poll();
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            var max = findMax(queue);
            largestValue.add(max);
        }

        return largestValue;
    }
}
