package com.mdt.LeetCode.Medium;

/**
 * Medium
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
 * subsequence, return 0.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class P1143LongestCommonSubsequence {

    int[][] arr;

    /**
     * idea is important:
     * case 1: P0 = " P1x" , Q0 = "  Q1 x"    یا اخرشون یکیه  =>  LCS (P0, Q0) = 1 + LCS(P1, Q1)
     * case 2: P0 = "    x" , Q0 = "     y" یا یکی نیست      =>   LCS (P0, Q0) = max { LCS(P1, Q0) , LCS(P0, Q1)}
     *
     * @param args
     */
    public static void main(String[] args) {
        var p = "abcdefghijklmnopqrstuvwxyz";
        var q = "ace";

        var problem = new P1143LongestCommonSubsequence();
        System.out.println(problem.longestCommonSubsequence(p, q));
    }

    public int longestCommonSubsequence(String text1, String text2) {

        arr = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++)
                arr[i][j] = -1;
        }
        return lcs(text1, text2, text1.length(), text2.length());
    }

    /**
     * this solution is not efficient enough. because it also uses recursive and for large strings, we might get
     * stackoverflow exception. So we need bottom-up approach.
     *
     * @param text1
     * @param text2
     * @param n
     * @param m
     * @return
     */
    private int lcs(String text1, String text2, int n, int m) {
        int result = 0;
        if (arr[n][m] != -1) return arr[n][m];
        if (n == 0 || m == 0) result = 0;
        else if (text1.charAt(n - 1) == text2.charAt(m - 1))
            result = 1 + lcs(text1, text2, n - 1, m - 1);
        else {
            var tmp1 = lcs(text1, text2, n - 1, m);
            var tmp2 = lcs(text1, text2, n, m - 1);
            result = Math.max(tmp1, tmp2);
        }
        arr[n][m] = result;
        return result;
    }
}
