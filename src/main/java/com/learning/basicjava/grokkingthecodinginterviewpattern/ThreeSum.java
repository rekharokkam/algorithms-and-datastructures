package com.learning.basicjava.grokkingthecodinginterviewpattern;

import java.util.Arrays;

/**
 * Given an array of integers, nums, and an integer value, target,
 * determine if there are any three integers in nums whose sum is equal to the target,
 * that is, nums[i] + nums[j] + nums[k] == target.
 * Return TRUE if three such integers exist in the array. Otherwise, return FALSE.
 *
 * Constraints:
 * 3 ≤ nums.length ≤ 500
 * −10pow(3) ≤ nums[i] ≤ 10pow(3)
 * −10pow(3) ≤ target ≤ 10pow(3)
 *
 * Test cases
 * [1, -1, 0] target: -1
 * [3, 7, 1, 2, 8, 4, 5] target: 10
 * [3, 7, 1, 2, 8, 4, 5] target: 21
 * [-1, 2, 1, -4, 5, -3] target: -8
 * [-1, 2, 1, -4, 5, -3] target: 0
 * [-396,420,-914,-125,665,321,724,-325,-51,-186,743,89,121,-307,-93,128,-367,73,-626,-884,50,665,879,-917,-108,984,553,-968,980,726,-703,616,179,750,-535,959,-820,643,976,-474,832,170,-469,-958,741,911,-966,858,-301,-189,332,-344,39,-401,-787,-709,-465,31,-69,793,-862,112,-926,-639,566,811,-217,-256,-335,361,-492,50,178,-579,-157,-938,-659,-333,689,-142,433,325,-870,-419,-427,358,-48,-27,188,-77,972,-429,340,615,-511,175,322,146,-416,-77,813,-417,-375,49,-285,-826,245,-464,-942,510,246,639,780,199,449,323,-797,-381,-512,679,-332,-718,401,772,-758,654,-398,676,37,-420,-164,239,-553,-669,-818,-209,-872,247,-690,822,-271,929,-859,7,605,694,361,102,-147,568,827,116,-728,65,-74,-654,638,856,-813,17,330,755,-565]
 */
public class ThreeSum {

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            for (int low = (i + 1), high = (i + 2); high < nums.length; low ++, high ++){
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    System.out.println("i : " + i + " :: nums[i] : " + nums[i]);
                    System.out.println("low : " + low + " :: nums[i] : " + nums[low]);
                    System.out.println("high : " + high + " :: nums[i] : " + nums[high]);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findSumOfThreeGPT(int[] nums, int target) {
        // Step 1: Sort the array to use the two-pointer technique
        Arrays.sort(nums);

        // Step 2: Loop through each number in the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates to avoid checking the same triplet multiple times. Ignore for now
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }

            // Step 3: Use two pointers to find the other two numbers
            int left = i + 1;   // Left pointer starts just after i
            int right = nums.length - 1;  // Right pointer starts at the end of the array

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    // Triplet found, return true
                    return true;
                } else if (currentSum < target) {
                    // If sum is less than target, move the left pointer to the right to increase the sum
                    left++;
                } else {
                    // If sum is greater than target, move the right pointer to the left to decrease the sum
                    right--;
                }
            }
        }

        // No such triplet found, return false
        return false;
    }


    public static void main(String[] args) {
        boolean isThreeSum = findSumOfThree(new int[]
                {-396,420,-914,-125,665,321,724,-325,-51,-186,743,89,121,-307,-93,128,-367,73,-626,-884,50,665,879,-917,-108,984,553,-968,980,726,-703,616,179,750,-535,959,-820,643,976,-474,832,170,-469,-958,741,911,-966,858,-301,-189,332,-344,39,-401,-787,-709,-465,31,-69,793,-862,112,-926,-639,566,811,-217,-256,-335,361,-492,50,178,-579,-157,-938,-659,-333,689,-142,433,325,-870,-419,-427,358,-48,-27,188,-77,972,-429,340,615,-511,175,322,146,-416,-77,813,-417,-375,49,-285,-826,245,-464,-942,510,246,639,780,199,449,323,-797,-381,-512,679,-332,-718,401,772,-758,654,-398,676,37,-420,-164,239,-553,-669,-818,-209,-872,247,-690,822,-271,929,-859,7,605,694,361,102,-147,568,827,116,-728,65,-74,-654,638,856,-813,17,330,755,-565},
                -21);
        System.out.println(isThreeSum);
    }
}
