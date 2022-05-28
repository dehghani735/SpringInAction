package com.mdt.HackerRank.Algorithm.C4;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public static class Graph {
        private        Node[] nodes;
        private static int    EDGE_DISTANCE = 6;

        public Graph(int size) {}

        private class Node {}

        private Node getNode(int id)               {}

        public void addEdge(int first, int second) {}

        public int[] shortestReach(int startId) {
            var queue = new LinkedList<Integer>();
            queue.add(startId);

            var distances = new int[nodes.length];
            Arrays.fill(distances, -1);
            distances[startId] = 0;

            while (!queue.isEmpty()) {
                var node = queue.poll();
                for (var neighbor : nodes[node].neighbors()) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[node] + EDGE_DISTANCE;
                        queue.add(neighbor);
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {

    }
}
