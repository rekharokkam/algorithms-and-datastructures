package com.learning.basicjava.grokkingthecodinginterviewpattern.twopointers;

import java.util.Arrays;

/**
 * Given an array, colors, which contains a combination of the following three elements:
 *
 * 0 (representing red)
 * 1 (representing white)
 * 2 (representing blue)
 *
 * Sort the array in place so that the elements of the same color are adjacent, with the colors in the order of red, white, and blue. To improve your problem-solving skills, do not utilize the built-in sort function.
 *
 * Constraints:
 *
 * 1≤ colors.length ≤ 300
 * colors[i] can only contain 0s, 1s, or 2s.
 *
 * Test cases:
 * [0. 1. 0]
 * [1]
 * [2, 2]
 * [1, 1, 0, 2]
 * [2, 1, 1, 0, 0]
 * [0, 0, 1, 0, 1, 1, 1, 2, 1, 2]
 * [2, 2, 0, 1, 2, 2, 0, 2]
 * [2, 2, 1, 1, 0]
 */

public class SockSorting {

    public static int[] sortColors (int[] colors) {
        int start = 0, current = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                int temp = colors[start];
                colors[start] = colors [current];
                colors[current] = temp;

                current ++;
                start ++;
            } else if (colors[current] == 1) {
                current ++;
            } else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;
                end --;
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        int[] sockArray = new int[] {0, 0, 1, 0, 1, 1, 1, 2, 1, 2};
        System.out.println("Before");
        Arrays.stream(sockArray).forEach(value -> {
            System.out.printf("\t" + value);
        });
        sortColors(sockArray);
        System.out.println("\nAfter" );
        Arrays.stream(sockArray).forEach(value -> {
            System.out.printf("\t" + value);
        });
    }
}
