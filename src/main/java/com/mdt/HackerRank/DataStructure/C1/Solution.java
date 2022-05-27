package com.mdt.HackerRank.DataStructure.C1;

import org.slf4j.Logger;

import java.util.Stack;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Balanced Parentheses in Expression
 * youtube video of hacker rank data structures playlist
 * @author detafti
 *
 * May 19, 2022
 */
public class Solution {
    private static final Logger log = getLogger(Solution.class);

    public static char[][] TOKENS = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (var c : expression.toCharArray()) {
            if (isOpenTerm(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !matches(stack.pop(), c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(Character openTerm, char closeTerm) {
        for (var t : TOKENS) {
            if (t[0] == openTerm)
                return t[1] == closeTerm;
        }
        return false;
    }

    private static boolean isOpenTerm(char c) {
        for (var t : TOKENS) {
            if (t[0] == c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var result = Solution.isBalanced("[()]}");
        log.info(String.valueOf(result));
    }
}
