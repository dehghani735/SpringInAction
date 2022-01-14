package com.mdt.CrackingInterview.chapter1;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 * a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be limited to just
 * dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat'; "atc o cta·; etc.)
 * <p>
 * date: 1/7/22
 */
public class Q4 {

    private static final Logger log = getLogger(Q4.class);

    /**
     * This is a question where it helps to figure out what it means for a string to be a permutation of a palindrome.
     * This is like asking what the "defining features" of such a string would be.
     *
     * @param args
     */
    public static void main(String[] args) {
        var q4 = new Q4();
        // Note
        log.info(String.valueOf(Character.getNumericValue('a')));
        log.info(String.valueOf(Character.getNumericValue('A')));

        log.info(String.valueOf(q4.isPermutationOfPalindrome1("Tact Coa")));
        log.info(String.valueOf(q4.isPermutationOfPalindrome2("Tact Coa")));
        log.info(String.valueOf(q4.isPermutationOfPalindrome3("Tact Coa")));

        // NOTE
        log.info(String.valueOf(Integer.MAX_VALUE)); // 2^31 - 1
        log.info(String.valueOf(Integer.MIN_VALUE)); // -2^31

        // Some useful Notes about Integer
        log.info(Integer.toBinaryString(16));
        log.info(String.valueOf(Integer.bitCount(7)));
        log.info(String.valueOf(Integer.toHexString(7)));
        log.info(String.valueOf(Integer.toOctalString(7)));
        log.info(String.valueOf(Integer.parseInt("7")));
        log.info(String.valueOf(Integer.parseInt("10", 8))); // Exciting, 8 got Exception
    }

    boolean isPermutationOfPalindrome1(String str) {
        var table = buildCharFrequencyTable(str);
        return checkOneOdd(table);
    }

    /**
     * @param str
     * @return
     */
    private int[] buildCharFrequencyTable(String str) {
        var table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (var c : str.toCharArray()) {
            var num = getCharNumber(c);
            if (num != -1)
                table[num]++;
        }

        return table;
    }

    private boolean checkOneOdd(int[] table) {
        var alreadyFoundOdd = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] % 2 != 0) {
                if (alreadyFoundOdd)
                    return false;
                alreadyFoundOdd = true;
            }
        }

        return true;
    }

    private int getCharNumber(char c) {
        var a   = Character.getNumericValue('a'); // Important Note: a and A has the same numeric value!
        var z   = Character.getNumericValue('z');
        var val = Character.getNumericValue(c);

        if (val >= a && val <= z)
            return val - a;

        return -1;
    }

    boolean isPermutationOfPalindrome2(String str) {
        var table        = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        var numberOfOdds = 0;
        for (var c : str.toCharArray()) {
            var num = getCharNumber(c);
            if (num != -1) {
                table[num]++;
                if (table[num] % 2 != 0)
                    numberOfOdds++;
                else
                    numberOfOdds--;
            }
        }

        return numberOfOdds <= 1;
    }

    /**
     * idea: bit vector
     */
    boolean isPermutationOfPalindrome3(String str) {
        var bitVector = createBitVector(str);
        return bitVector == 0 || atMostOneBitSet(bitVector);
    }

    /**
     * Note 1: complement 2: from right side, go until first 1, left it and complement to the left.
     * 0000 0001  - complement 2 -> 1111 1111
     * (0001 0000)  - 1  = 0001 0000 + 1111 1111 = 0000 1111
     * <p>
     * Note 2: to check if one bit is one
     *
     * @param bitVector
     * @return
     */
    private boolean atMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private int createBitVector(String str) {
        var bitVector = 0;
        for (var c : str.toCharArray()) {
            bitVector = toggle(bitVector, c);
        }

        return bitVector;
    }

    private int toggle(int bitVector, char c) {
        var num = getCharNumber(c);
        if (num < 0)
            return bitVector;

        var mask = 1 << num;
        if ((bitVector & mask) == 0)
            bitVector |= mask;
        else
            bitVector &= ~mask;

        return bitVector;
    }
}
