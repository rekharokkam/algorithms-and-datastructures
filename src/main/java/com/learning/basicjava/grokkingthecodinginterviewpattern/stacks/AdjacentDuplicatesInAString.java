package com.learning.basicjava.grokkingthecodinginterviewpattern.stacks;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyStackWithSinglyLinkedList;

/**
 * You are given a string consisting of lowercase English letters.
 * Repeatedly remove adjacent duplicate letters, one pair at a time. Both members of a pair of adjacent duplicate letters need to be removed.
 *
 * Constraints:
 * 1 ≤ string.length ≤ 10 power 3
 * string consists of lowercase English alphabets.
 *
 * Test cases:
 * aaa, output : a
 * abbaaca, output : aca
 * sadkkdassasadkkdassa, output : sa
 * azxxzy, output : ay
 * abcde, output : abcde
 * aabbccdd, output : ""
 */
public class AdjacentDuplicatesInAString {

    public static String removeDuplicates(String s) {
        MyStackWithSinglyLinkedList stack = new MyStackWithSinglyLinkedList();
        for (char eachChar : s.toCharArray()) {
            String eachCharStr = String.valueOf(eachChar);
            if (!stack.empty() && (eachChar == stack.peek())) {
                stack.pop();
            } else {
                stack.push(eachChar);
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(AdjacentDuplicatesInAString.removeDuplicates("sasadkkdassa"));
    }
}
