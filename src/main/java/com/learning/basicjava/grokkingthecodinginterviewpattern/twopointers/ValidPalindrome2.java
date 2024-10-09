package com.learning.basicjava.grokkingthecodinginterviewpattern.twopointers;

/**
 * Write a function that takes a string as input and checks whether
 * it can be a valid palindrome by removing at most one character from it.
 *
 * Constraints:
 * 1 ≤ string.length ≤ 10 power 3
 * The string only consists of English letters.
 *
 * Test cases:
 * RACEACAR - true
 * abbababa - true
 * abcdeca - false
 * madame - true
 * dead - true
 * abca - true
 * tebbem - false
 * eeccccbebaeeabebccceea - false
 */
public class ValidPalindrome2 {

    public static boolean isTwoPointerPalindrome(String string) {
        //loop through to find the mismatch
        for (int start = 0, end = string.length()-1; start < string.length()/2; start ++, end--) {
            if ( string.charAt(start) != string.charAt(end)) {
                return (isPalindrome(string.substring(start, end--))
                    || (isPalindrome(string.substring(start + 1, end))));
            }
        }
        return true;
    }

    private static boolean isPalindrome (String palindrome) {
        for (int start = 0, end = palindrome.length() -1; start < palindrome.length()/2; start ++, end --) {
            if (palindrome.charAt(start) != palindrome.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isTwoPointerPalindrome ("eeccccbebaeeabebccceea"));
    }
}
