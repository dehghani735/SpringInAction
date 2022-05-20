package com.mdt.CrackingInterview.chapter3;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 3.1 Three in One: Describe how you could use a single array to implement three stacks.
 * <p>
 * date: 1/28/22
 */
public class Q1 {
    private static final Logger log = getLogger(Q1.class);

    public static void main(String[] args) throws Exception {
        var stack = new FixedMultiStack(5);
        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(1, 3);
        stack.push(1, 4);
        stack.push(1, 5);

        log.info(String.valueOf(stack.peek(1)));
        log.info(String.valueOf(stack.pop(1)));
        log.info(String.valueOf(stack.peek(1)));
        log.info(String.valueOf(stack.peek(2)));
    }

    // TODO implement flexible stack size in book. it has important notes about java concepts like inner class and others.
}
