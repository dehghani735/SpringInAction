package com.mdt.LeetCode;

import java.util.Arrays;

/**
 * Easy
 * <p>
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * <p>
 * date: 7/06/22
 */
public class P1189MaximumNumberOfBalloons {

    /**
     * my solution
     *
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
        var dict = new int[26];

        for (var c : text.toCharArray()) {
            dict[c - 'a']++;
        }

        var bCount = dict['b' - 'a'];
        var aCount = dict[0];
        var lCount = dict['l' - 'a'] / 2;
        var oCount = dict['o' - 'a'] / 2;
        var nCount = dict['n' - 'a'];
        var counts = new int[]{aCount, bCount, lCount, oCount, nCount};
        Arrays.sort(counts);
        return counts[0];
    }

    /**
     * Nick's solution
     *
     * @param text
     * @return
     */
    public int maxNumberOfBalloons2(String text) {
        var dict = new int[26];

        for (var c : text.toCharArray()) {
            dict[c - 'a']++;
        }

        var min = dict['b' - 'a'];
        min = Math.min(dict[0], min);
        min = Math.min(dict['l' - 'a'] / 2, min);
        min = Math.min(dict['o' - 'a'] / 2, min);
        min = Math.min(dict['n' - 'a'], min);
        return min;
    }

    public static void main(String[] args) {
        var problem = new P1189MaximumNumberOfBalloons();
        System.out.println(problem.maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"
        ));
    }
}
