package com.learning.basicjava.grokkingthecodinginterviewpattern.twopointers;

/**
 * https://www.educative.io/courses/grokking-coding-interview/valid-palindrome
 * Write a function that takes a string, s, as an input and determines whether or not it is a palindrome.
 *
 * Constraints:
 * 1 ≤ s.length ≤ 2×10 power 5
 * The string s will not contain any white space and will only consist of ASCII characters(digits and letters).
 *
 * Test cases
 * kaYak
 * hello
 * RaCECAR
 * A
 * ABCDABCD
 *
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        if (s.length() == 1){
            return true;
        }
//        Initialize two pointers at the beginning and end of the string
        for (int left = 0, right = s.length() - 1; left < s.length()/2; left ++, right --){

//          Check whether the current pair of characters is identical.
            if (s.charAt(left) != s.charAt(right))
            {
//                If they are not Identical return false
                return false;
            }
//            move both pointers by 1 index towards the middle.
//            Keep traversing them towards the middle until they meet
        }
//        If we reach the middle of the string without finding a mismatch then it's a palindrome.
//        return TRUE
        return true;
    }

    public static void main(String[] args) {
        System.out.println("output : " + isPalindrome ("ABCDABCD"));
    }
}
