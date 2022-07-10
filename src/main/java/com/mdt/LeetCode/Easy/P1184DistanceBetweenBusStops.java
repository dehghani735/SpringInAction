package com.mdt.LeetCode.Easy;

/**
 * Easy
 * <p>
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
 * <p>
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 * <p>
 * Return the shortest distance between the given start and destination stops.
 * <p>
 * date: 6/21/22
 */
public class P1184DistanceBetweenBusStops {

    /**
     * nick's solution. very smart and challenging
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        var clockWiseCounter = 0;
        var totalCounter     = 0;

        for (var i = 0; i < distance.length; i++) {
            if (start < destination && (i >= start && i < destination))
                clockWiseCounter += distance[i];
            if (start > destination && (i >= start || i < destination)) // or is important
                clockWiseCounter += distance[i];

            totalCounter += distance[i];
        }

        return Math.min(clockWiseCounter, totalCounter - clockWiseCounter);
    }
}
