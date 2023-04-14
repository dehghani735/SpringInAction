package com.mdt.FunctionalAndReactive.M10_Streams.M10_16_Statefulness;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessStatefulOp {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 4, 5, 6, 7, 8, 9);

        List<Integer> collect = list.stream()
//                .parallelStream() // avoid using it while using stateful intermediate operations
                .skip(2)  // is not good for parallel
                .limit(5) // is not good for parallel
                .collect(Collectors.toList());


    }
}
