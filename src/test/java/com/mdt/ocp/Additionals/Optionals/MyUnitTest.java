package com.mdt.ocp.Additionals.Optionals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyUnitTest {

    @Test
    void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);
    }
}