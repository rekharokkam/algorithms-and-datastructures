package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * Same as swap nodes in pairs but not Nodes, instead I am swapping the data
 * Input and output remain the same
 *
 * Given a singly linked list, swap every two adjacent nodes of the linked list. After the swap, return the head of the linked list.
 *
 *  Constraints:
 *  The number of nodes in the list is in the range [0,100].
 *   0 ≤ Node.value ≤ 100
 *
 *   Test cases:
 *   [9, 0, 8, 2]
 *   [0,8, 3, 1, 9, 2, 7]
 *   [1, 2, 3, 4, 5, 6]
 *   [10, 20, 30, 40, 50]
 */
public class SwapNodesInPairsData {
    public static LinkedListNode swapPairsData(LinkedListNode head) {
        LinkedListNode left = head, right = left.nextNode;

        while (null != left && null != right) {
            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            left = right.nextNode;
            right = (null != left) ? left.nextNode : null;
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        [9, 0, 8, 2]
//        linkedList.add (9);
//        linkedList.add (0);
//        linkedList.add (8);
//        linkedList.add (2);

//        [0,8, 3, 1, 9, 2, 7]
//        linkedList.add (0);
//        linkedList.add (8);
//        linkedList.add (3);
//        linkedList.add (1);
//        linkedList.add (9);
//        linkedList.add (2);
//        linkedList.add (7);

//        [1, 2, 3, 4, 5, 6]
//        linkedList.add (1);
//        linkedList.add (2);
//        linkedList.add (3);
//        linkedList.add (4);
//        linkedList.add (5);
//        linkedList.add (6);

//        [10, 20, 30, 40, 50]
//        linkedList.add (10);
//        linkedList.add (20);
        linkedList.add (30);
        linkedList.add (40);
        linkedList.add (50);

        System.out.println("BEFORE : " + linkedList.toString());
        LinkedListNode newLink = swapPairsData (linkedList.head);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));
    }
}
