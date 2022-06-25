package com.mdt.LeetCode;

/**
 *
 */
public class P860LemonadeChange {

    /**
     * my complex solution
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        var count = new int[3];
        for (var i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                count[0]++;
            else if (bills[i] == 10) {
                count[1]++;
                if (count[0] < 1)
                    return false;
                count[0]--;
            } else {
                count[2]++;
                if (count[0] == 0)
                    return false;

                if (count[1] == 0 && count[0] < 3)
                    return false;

                if (count[1] == 0)
                    count[0] = count[0] - 3;
                else {
                    count[0]--;
                    count[1]--;
                }
            }
        }

        return true;
    }

    /**
     * nick's easy solution
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange2(int[] bills) {
        var fives = 0;
        var tens  = 0;
        for (var bill : bills) {
            if (bill == 5)
                fives++;
            else if (bill == 10) {
                tens++;
                fives--;
            } else if (tens > 0) {
                tens--;
                fives--;
            } else {
                fives -= 3;
            }

            if (fives < 0) return false;
        }

        return true;
    }
}
