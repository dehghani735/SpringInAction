package com.mdt.LeetCode;

/**
 * Easy
 * <p>
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 * <p>
 * We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
 * <p>
 * Return the reformatted license key.
 * <p>
 * date: 6/20/22
 */
public class P482LicenseKeyFormatting {

    /**
     * my complex and shet solution
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        var resTemp = s.replaceAll("-", "");

        var size = resTemp.length();
        if (size == 0)
            return "";
        var firstGroupSize = size % k == 0 ? k : size % k;

        var result = new StringBuilder();
        result.append(resTemp, 0, firstGroupSize);
        result.append("-");

        var rest = resTemp.substring(firstGroupSize);

        for (var i = 0; i < rest.length() / k; i++) {
            result.append(rest, k * i, k * i + k);
            result.append("-");
        }
        result.deleteCharAt(result.length() - 1);

        return result.toString();
    }

    /**
     * Nick's nice solution
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting2(String s, int k) {
        s = s.toUpperCase();
        s = s.replaceAll("-", "");

        var result = new StringBuilder(s); // interesting

        for (var i = s.length() - k; i > 0; i -= k) {
            result.insert(i, "-"); // interesting
        }
        return result.toString();
    }

    public static void main(String[] args) {
        var problem = new P482LicenseKeyFormatting();
        System.out.println(problem.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
}
