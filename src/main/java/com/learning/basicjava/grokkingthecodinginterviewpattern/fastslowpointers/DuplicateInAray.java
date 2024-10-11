package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

/**
 * Given an array of positive numbers, nums, such that the values lie in the range
 * [1,n], inclusive, and that there are n+1 numbers in the array, find and return the duplicate number present in nums.
 * There is only one repeated number in nums.
 *
 * Note: You cannot modify the given array nums.
 * You have to solve the problem using only constant extra space.
 *
 * Constraints:
 *
 * 1 ≤ n ≤ 10 power of 3
 * nums.length = n+1
 * 1 ≤ nums[i] ≤ n
 * All the integers in nums are unique, except for one integer that will appear more than once.
 *
 * Test cases:
 * [1, 5, 4, 3, 2, 4, 6]
 * [5, 6, 1, 3, 7, 3, 2, 4, 8]
 * [2, 10, 6, 7, 11, 7, 9, 4, 3, 8, 5, 1]
 * [9, 6, 12, 7, 15, 8, 3, 13, 2, 10, 4, 14, 1, 11, 9, 5]
 * [3, 4, 4, 4, 2]
 * [1, 1]
 * [1, 3, 4, 2, 2]
 * [1, 3, 6, 2, 7, 3, 5, 4]
 * [1, 2, 2]
 */
public class DuplicateInAray {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int duplicateNumber = findDuplicate(new int [] {1, 2, 2});
        System.out.println(duplicateNumber);
    }
}
