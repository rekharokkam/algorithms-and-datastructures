package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

/**
 * Write an algorithm to determine if a number n is a happy number.
 *
 * We use the following process to check if a given number is a happy number:
 * Starting with the given number
 * n, replace the number with the sum of the squares of its digits.
 *
 * Repeat the process until:
 * The number equals 1, which will depict that the given number
 * n is a happy number. The number enters a cycle, which will depict that the given number n is not a happy number.
 * Return TRUE if n is a happy number, and FALSE if not.
 *
 * Test case:
 * 16
 * 90
 * 1
 * 19
 * 8
 * 7
 * 2147483646
 * 4
 * 28
 */
public class HappyNumber {

    private static int sumOfSquares (int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

    public static boolean isHappyNumber(int n){
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        boolean isHappy = isHappyNumber(16);
        System.out.println(isHappy);
    }
}
