package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If the number of nodes in the linked list is even, there will be two middle nodes, so return the second one.
 *
 * Constraints:
 * Let n be the number of nodes in a linked list.
 * 1 ≤ n ≤ 100
 * 1 ≤ node.data ≤ 100
 * head ≠ NULL
 *
 * Test cases:
 * 2 → 4 → 6 → 8 → 10 → NULL
 * 1 → 3 → 5 → 7 → 9 → 11 → NULL
 * 16 → NULL
 * [1, 2, 3, 4, 5]
 * [1, 2, 3, 4, 5, 6]
 * [3, 2, 1]
 * [10]
 * [1,2]
 */
public class LinkedListMiddle {
    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        do {
            if (null == fast.nextNode) {
                return slow;
            }
            slow = (null != slow.nextNode) ? slow.nextNode : head;
            fast = fast.nextNode.nextNode;
            if (null == fast) {
                return slow;
            }
        } while (true);
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        linkedList.add (2);
//        linkedList.add (4);
//        linkedList.add (6);
//        linkedList.add (8);
//        linkedList.add (10);

//        linkedList.add (1);
//        linkedList.add (3);
//        linkedList.add (5);
//        linkedList.add (7);
//        linkedList.add (9);
//        linkedList.add (11);

        linkedList.add(16);

//        linkedList.add(1);
//        linkedList.add(2);

        System.out.println(linkedList.toString());
        LinkedListNode middleNode = middleNode (linkedList.head);
        System.out.println(middleNode.data);
    }
}
