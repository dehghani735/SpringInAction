package com.mdt.HackerRank.Algorithm.C14;


import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<Node>();

        private Node(int id) {
            this.id = id;
        }

        private Node getNode(int id) {
            return this; // TODO what?
        }

        public void addEdge(int source, int destination) {
            var s = getNode(source);
            var d = getNode(destination);
            s.adjacent.add(d);
        }

        public boolean hasPathDFS(int source, int destination) {
            var s       = getNode(source);
            var d       = getNode(destination);
            var visited = new HashSet<Integer>(); // it's the alternative for flags
            return hasPathDFS(s, d, visited);
        }

        private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
            if (visited.contains(source.id))
                return false;
            visited.add(source.id);
            if (source == destination)
                return true;
            for (var child : source.adjacent) {
                if (hasPathDFS(child, destination, visited))
                    return true;
            }
            return false;
        }

        public boolean hasPathBFS(int source, int destination) {
            return hasPathBFS(getNode(source), getNode(destination));
        }

        private boolean hasPathBFS(Node source, Node destination) {
            var nextToVisit = new LinkedList<Node>();
            var visited     = new HashSet<Integer>(); // it's the alternative for flags
            nextToVisit.add(source);
            while (!nextToVisit.isEmpty()) {
                var node = nextToVisit.remove();
                if (node == destination)
                    return true;
                if (visited.contains(node.id))
                    continue;
                visited.add(source.id);
                for (var child : node.adjacent) {
                    nextToVisit.add(child);
                }
            }
            return false;
        }
    }
}
