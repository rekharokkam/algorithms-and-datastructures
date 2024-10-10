package com.learning.basicjava.grokkingthecodinginterviewpattern.twopointers;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * Given a singly linked list, remove the nth node from the end of the list and return its head.
 *
 * Constraints:
 * The number of nodes in the list is k.
 * 1 <= k <= 10 power of 3
 * -10 power of 3 <= Node.value <= 10 power of 3
 * 1 <= n <= k
 *
 * Test Cases
 * [23, 28, 10, 5, 67, 39, 70, 28], n = 2
 * [34, 53, 6, 95, 38, 28, 17, 63, 16, 76], n = 3
 * [208, 224, 275, 390, 4, 383, 330, 60, 193], n = 4
 * [1, 2, 3, 4, 5, 6, 7, 8, 9], n = 1
 * [69, 8, 49, 106, 116, 112], n = 6
 */
public class RemoveNthNodeFromEndOfList {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode left = head;
        LinkedListNode right = head;

        int initialCounter = n;
        while (initialCounter > 0 && null != right) {
//            System.out.println("how many times : " + initialCounter);
//            System.out.println("right : " + right.data);
//            System.out.println("right.nextNode : " + right.nextNode.data);
            right = right.nextNode;
            initialCounter--;
        }

        if (right == null) { // n is same as the length of the list
            head = head.nextNode;
            return head;
        }

        while (right.nextNode != null) {
            right = right.nextNode;
            left = left.nextNode;
        }

        LinkedListNode tempNode = left.nextNode;
        left.nextNode = tempNode.nextNode;

        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.add(32);
//        linkedList.add (78);
//        linkedList.add (65);
//        linkedList.add (90);
//        linkedList.add (12);
//        linkedList.add (44);

//        linkedList.add (23);
//        linkedList.add (38);
//        linkedList.add (10);
//        linkedList.add (5);
//        linkedList.add (67);
//        linkedList.add (39);
//        linkedList.add (70);
//        linkedList.add (28);

        linkedList.add (69);
        linkedList.add (8);
        linkedList.add (49);
        linkedList.add (106);
        linkedList.add (116);
        linkedList.add (112);


        System.out.println(linkedList);

//        removeNthLastNode (linkedList.head, 3);
//        removeNthLastNode (linkedList.head, 2);
        LinkedListNode headNode = removeNthLastNode (linkedList.head, 6);
        linkedList.head = headNode;
        System.out.println(linkedList);
    }
}
