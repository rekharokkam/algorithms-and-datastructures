package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.*;

/**
 * Given the head of a linked list, your task is to check whether the linked list is a palindrome or not. Return TRUE if the linked list is a palindrome; otherwise, return FALSE.
 *
 * Note: The input linked list prior to the checking process should be identical to the list after the checking process has been completed.
 *
 * Constraints:
 * Let n be the number of nodes in a linked list.
 * 1 ≤ n ≤ 500
 * 0 ≤ Node.value ≤ 9
 *
 * Test cases:
 * [1, 1, 1, 0, 0, 1, 1, 1]
 * [8, 5, 6, 0, 1, 0, 5, 8]
 * [1, 2, 3, 4, 4, 5, 5, 3, 2, 1]
 * [7, 3, 3, 3, 7]
 * [1, 2, 3, 2, 1]
 * [4, 7, 9, 5, 4]
 * [2, 3, 5, 5, 3, 2]
 * [6, 1, 0, 5, 1, 6]
 * [3, 6, 9, 8, 4, 8, 9, 6, 3]
 */
public class PalindromeLinkedList {

    public static boolean palindrome(LinkedListNode head) {

        //first find the middle of the list
        LinkedListNode slow = head, fast = head;

        do{
            if (null != fast.nextNode) {
                slow = slow.nextNode;
                fast = fast.nextNode.nextNode;
            } else {
                fast = null;
            }

            //we found the middle of the linked list
            if (null == fast) {
                //reverse the linked list
                LinkedListNode reversedNode = ReverseLinkedList.revereLinkedList(slow);

                //compare the original first half of the list with the reversed second half of the array
                return areTwoListsSame (head, reversedNode);
            }
        } while (true);
    }

    private static boolean areTwoListsSame (LinkedListNode originalHead, LinkedListNode reversedHead) {
        LinkedListNode slow = originalHead, reversedListSlow = reversedHead;

        while (true) {
            if (slow.data != reversedListSlow.data) {
                return false;
            }
            if (null == slow.nextNode || null == reversedListSlow.nextNode) {
                return true;
            }

            slow = slow.nextNode;
            reversedListSlow = reversedListSlow.nextNode;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add (2);
        linkedList.add (4);
        linkedList.add (6);
        linkedList.add (8);
        linkedList.add (10);

//        linkedList.add (1);
//        linkedList.add (1);
//        linkedList.add (1);
//        linkedList.add (0);
//        linkedList.add (0);
//        linkedList.add (1);
//        linkedList.add (1);
//        linkedList.add (1);

//        8, 5, 6, 0, 1, 0, 5, 8
//        linkedList.add (8);
//        linkedList.add (5);
//        linkedList.add (6);
//        linkedList.add (0);
//        linkedList.add (1);
//        linkedList.add (0);
//        linkedList.add (5);
//        linkedList.add (8);

//        [1, 2, 3, 4, 4, 5, 5, 3, 2, 1]
//        linkedList.add (1);
//        linkedList.add (2);
//        linkedList.add (3);
//        linkedList.add (4);
//        linkedList.add (4);
//        linkedList.add (5);
//        linkedList.add (5);
//        linkedList.add (3);
//        linkedList.add (2);
//        linkedList.add (1);

//        [7, 3, 3, 3, 7]
//        linkedList.add (7);
//        linkedList.add (3);
//        linkedList.add (3);
//        linkedList.add (3);
//        linkedList.add (7);

        linkedList.add(16);

        boolean isTheListPalindrome = palindrome (linkedList.head);
        System.out.println(isTheListPalindrome);
    }
}
