package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 * <p>
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the last person.
 * <p>
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
 * <p>
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily one more than the previous gift).
 * <p>
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 * <p>
 * date: 7/07/22
 */
public class P1103DistributeCandiesToPeople {

    /**
     * my solution, nice
     *
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        var result = new int[num_people];
        var i      = 0;
        var round  = 0;
        while (candies > 0) {
            var distribute = Math.min(candies, (round * num_people) + (i + 1));
            result[i] += distribute;
                         candies -= distribute;
            if (i + 1 == num_people)
                round++;
            i = (i + 1) % num_people;
        }
        return result;
    }
}
