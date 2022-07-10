package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 * 3. There is exactly one person that satisfies properties 1 and 2.
 * <p>
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 * <p>
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 * <p>
 * date: 7/10/22
 */
public class P997FindTheTownJudge {

    /**
     * my solution
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1;

        var counterOne   = new int[n + 1];
        var counterJudge = new int[n + 1];
        for (var t : trust) {
            counterOne[t[0]]++;
            counterJudge[t[1]]++;
        }

        var judge = 0;
        var max   = 0;
        for (var i = 1; i < n + 1; i++) {
            if (counterJudge[i] > max) {
                judge = i;
                max   = counterJudge[i];
            }
        }
        if (counterOne[judge] == 0 && counterJudge[judge] == n - 1)
            return judge;

        return -1;
    }

    /**
     * Nick's solution. smarter idea
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge2(int n, int[][] trust) {
        var counter = new int[n + 1];
        for (var t : trust) {
            counter[t[0]]--;
            counter[t[1]]++;
        }

        for (var i = 1; i <= n; i++)
            if (counter[i] == n - 1)
                return i;

        return -1;
    }
}
