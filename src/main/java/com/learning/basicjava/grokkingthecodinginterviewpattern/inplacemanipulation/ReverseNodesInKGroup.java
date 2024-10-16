package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers.ReverseLinkedList;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * The task is to reverse the nodes in groups of k in a given linked list, where k is a positive integer,
 * and at most the length of the linked list.
 * If any remaining nodes are not part of a group of k, they should remain in their original order.
 *
 * It is not allowed to change the values of the nodes in the linked list.
 * Only the order of the nodes can be modified.
 *
 * Constraints:
 * Let n be the number of nodes in a linked list.
 * 1 ≤ k ≤ n ≤ 500
 * 0 ≤ Node.value ≤ 1000
 *
 * Testcases:
 * [1, 2, 3, 4, 5], Ans - [3, 2, 1, 4, 5]
 * [6, 7, 8], Ans - [8, 7, 6]
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13], Ans - [3, 2, 1,
 * [0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13],
 * Ans - [2 , 1 , 0 , 5 , 4 , 3 , 8 , 7 , 6 , 11 , 10 , 9 , 12 , 13]
 */
public class ReverseNodesInKGroup {

    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
        LinkedListNode groupStart = head, newHead = null, next = head, groupEnd = null,
                previousGroupEnd = null;

        while (null != next) {
            int counter = k;
            boolean isGroupComplete = true;
            groupStart = next;
            while (counter -- > 1){
                next = next.nextNode;
                if (null == next) {
                    isGroupComplete = false;
                    break;
                }
            }

            if(isGroupComplete) {
                groupEnd = next;
                next = next.nextNode;
                groupEnd.nextNode = null;
                LinkedListNode reversedList = ReverseLinkedList.revereLinkedList(groupStart);

                if (previousGroupEnd != null) {
                    previousGroupEnd.nextNode = reversedList;
                }
                previousGroupEnd = groupStart;
                groupStart.nextNode = next;
                if (null == newHead) {
                    newHead = reversedList;
                }
            } else {
                if (null == newHead) {
                    newHead = head;
                }
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        linkedList.add (1);
//        linkedList.add (2);
//        linkedList.add (3);
//        linkedList.add (4);
//        linkedList.add (5);

//        linkedList.add (6);
//        linkedList.add (8);
//        linkedList.add (7);

//        head → 8 → 0 → 6 → 1 → 0 → 7 → 8 → 7 → 5 → 3 → 5 → 2 → 4 → 9 → NULL
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(12);
        linkedList.add(13);

        System.out.println("BEFORE : " + linkedList.toString());
        LinkedListNode newLink = reverseKGroups (linkedList.head, 3);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));
    }
}
