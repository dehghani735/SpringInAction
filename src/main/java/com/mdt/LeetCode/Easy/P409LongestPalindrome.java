package com.mdt.LeetCode.Easy;

import java.util.HashMap;

/**
 * Easy
 * <p>
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 * date: 6/30/22
 */
public class P409LongestPalindrome {

    /**
     * my solution. nick's solution was the same but he used a int array of size 128.
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        var chars   = s.toCharArray();
        var hashMap = new HashMap<Character, Integer>();

        for (var c : chars) {
            var counter = hashMap.getOrDefault(c, 0);
            hashMap.put(c, ++counter);
        }
        var sum    = 0;
        var hasOdd = false;
        for (var count : hashMap.values()) {
            if (count % 2 == 0)
                sum += count;
            else {
                sum += (count - 1);
                hasOdd = true;
            }
        }
        if (hasOdd) sum++;

        return sum;
    }

    public static void main(String[] args) {
        var problem = new P409LongestPalindrome();
        System.out.println(problem.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
