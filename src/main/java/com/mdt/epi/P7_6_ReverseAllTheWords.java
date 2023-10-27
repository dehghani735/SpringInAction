package com.mdt.epi;

public class P7_6_ReverseAllTheWords {

    public void reverseWords(char[] input) {
        // Reverses the whole string first
        reverse(input, 0, input.length);

        int start = 0, end;
        while ((end = find(input, ' ', start)) != -1) {
            // Reverses each word in the string.
            reverse(input, start, end);
            start = end + 1;
        }

        // Reverses the last word
        reverse(input, start, input.length);
    }

    public void reverse(char[] array, int start, int stopIndex) {
        if (start >= stopIndex)
            return;

        int last = stopIndex - 1;
        for (int i = start; i <= start + (last - start) / 2; i++) {
            char tmp = array[i];
            array[i] = array[last - i + start];
            array[last - i + start] = tmp;
        }
    }

    public int find(char[] array, char c, int start) {
        for (int i = start; i < array.length; i++) {
            if (array[i] == c)
                return i;
        }

        return -1;
    }
}
