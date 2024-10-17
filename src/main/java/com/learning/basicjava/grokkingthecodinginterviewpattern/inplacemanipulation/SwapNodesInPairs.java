package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers.ReverseLinkedList;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * Given a singly linked list, swap every two adjacent nodes of the linked list. After the swap, return the head of the linked list.
 *
 * Note: Solve the problem without modifying the values in the list’s nodes. In other words, only the nodes themselves can be changed.
 *
 * Constraints:
 * The number of nodes in the list is in the range [0,100].
 * 0 ≤ Node.value ≤ 100
 *
 * Test cases:
 * [9, 0, 8, 2]
 * [0,8, 3, 1, 9, 2, 7]
 * [1, 2, 3, 4, 5, 6]
 * [10, 20, 30, 40, 50]
 */
public class SwapNodesInPairs {

    public static LinkedListNode swapPairs(LinkedListNode head) {
        LinkedListNode current = head, subGroupStart = head,
                subGroupEnd = null, previousGroupEndNode = null, newHead = null;

        while (null != current) {
            boolean isGroupComplete = true;
            int initialCounter = 2;
            subGroupStart = current;

            while (initialCounter-- > 1) {
                current = current.nextNode;
                if (null == current) {
                    isGroupComplete = false;
                    break;
                }
            }

            if (isGroupComplete) {
                subGroupEnd = current;
                current = current.nextNode;
                subGroupEnd.nextNode = null;
                if (null != previousGroupEndNode) {
                    previousGroupEndNode.nextNode = null;
                }

                LinkedListNode reversedSubGroupStart = ReverseLinkedList.revereLinkedList(subGroupStart);

                if (null != previousGroupEndNode) {
                    previousGroupEndNode.nextNode = reversedSubGroupStart;
                }

                previousGroupEndNode = subGroupStart;
                subGroupStart.nextNode = current;
                if (null == newHead) {
                    newHead = reversedSubGroupStart;
                }
            }
            newHead = (null == newHead) ? head : newHead;
        }
        return newHead;
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
        linkedList.add (10);
        linkedList.add (20);
        linkedList.add (30);
        linkedList.add (40);
        linkedList.add (50);


//        head → 8 → 0 → 6 → 1 → 0 → 7 → 8 → 7 → 5 → 3 → 5 → 2 → 4 → 9 → NULL
//        linkedList.add(0);
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        linkedList.add(4);
//        linkedList.add(5);
//        linkedList.add(6);
//        linkedList.add(7);
//        linkedList.add(8);
//        linkedList.add(9);
//        linkedList.add(10);
//        linkedList.add(11);
//        linkedList.add(12);
//        linkedList.add(13);

        System.out.println("BEFORE : " + linkedList.toString());
        LinkedListNode newLink = swapPairs (linkedList.head);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));
    }
}
