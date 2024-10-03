package com.learning.basicjava.coursera.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Problem statement: You are given an array of socks, You need to determine how many pairs of each color sock.
 * Also total number of pairs available.
 *
 * yellow sock - 1
 * blue sock - 2
 * red sock - 3
 * green sock - 4
 * orange sock - 5
 *
 * Array - [1, 2, 2, 1, 1, 3, 5, 5, 5, 1, 1, 1, 1, 4, 4]
 */


public class SockSorting {

    public static final Map<Integer, String> NUMBER_TO_COLOR_MAP = new HashMap<>();

    static {
        NUMBER_TO_COLOR_MAP.put(1, "yellow sock");
        NUMBER_TO_COLOR_MAP.put(2, "blue sock");
        NUMBER_TO_COLOR_MAP.put(3, "red sock");
        NUMBER_TO_COLOR_MAP.put(4, "green sock");
        NUMBER_TO_COLOR_MAP.put(5, "orange sock");
    }

    public static Map <String, Integer> sockCount (int[] socks) {
        Map<Integer, Integer> sockCountMap = new HashMap<>();

        Arrays.stream(socks).forEach(i -> {
            if (sockCountMap.containsKey(i)) {
                Integer sockCountInt = sockCountMap.get(i);
                sockCountMap.replace(i, sockCountInt,
                        ++sockCountInt);
            } else {
                sockCountMap.put(i, 1);
            }
        });

        Map<String, Integer> mappedSockCount = new HashMap<>();
        sockCountMap.forEach((i, count) -> {
            if (count == 1) {
                mappedSockCount.put(NUMBER_TO_COLOR_MAP.get(i), 0);
            }
            else if (count % 2 == 0){
                mappedSockCount.put(NUMBER_TO_COLOR_MAP.get(i),
                        count/2);
            } else
            mappedSockCount.put(NUMBER_TO_COLOR_MAP.get(i),
                    (count-1)/2);
        });
        mappedSockCount.put("total number of pairs",
                mappedSockCount.values().stream().mapToInt(Integer::intValue).sum());
        return mappedSockCount;
    }

    public static void main(String[] args) {
        Map<String, Integer> sockCount = SockSorting.sockCount(
                IntStream.of(1, 2, 2, 1, 1, 3, 5, 5, 5, 1, 1, 1, 1, 4, 4).toArray());
        System.out.println(sockCount);
    }
}
