package com.mdt.CrackingInterview.chapter3;

/**
 *
 */
public class MultiStack {

    private int[] values;

    private static class StackInfo {
        public int start, size, capacity;

        public StackInfo(int start, int capacity) {
            this.start    = start;
            this.capacity = capacity;
        }

//        public boolean isWithinStackCapacity(int index) {
//            if (index < 0 || index >= values.length)
//                return false;
//        }
    }
}
