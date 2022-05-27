package com.mdt.HackerRank.DataStructure.C8;

/**
 * Trie
 *
 * TODO I don't understand it too much
 */
public class Solution {

    public static class Node {
        private static int NUMBER_OF_CHARACTERS = 26;
        Node[] children = new Node[NUMBER_OF_CHARACTERS]; // could be hashmap
        int    size     = 0;

        private static int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            if (index == s.length()) return;
            char current  = s.charAt(index);
            int  charCode = getCharIndex(current);
            var  child    = getNode(current);
            if (child == null) {
                child = new Node();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }

        /**
         * TODO I don't get it too much
         * @param s
         * @param index
         * @return
         */
        public int findCount(String s, int index) {
            if (index == s.length())
                return size;
            var child = getNode(s.charAt(index));
            if (child == null)
                return 0;
            return child.findCount(s, index + 1);
        }
    }
}
