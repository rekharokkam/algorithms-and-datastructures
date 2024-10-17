package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * Given the linked list and an integer, k, return the head of the linked list after swapping the values of the k th node from the beginning and the k th node from the end of the linked list.
 *
 *  Note: We’ll number the nodes of the linked list starting from 1 to n.
 *
 * Constraints:
 * The linked list will have n number of nodes.
 * 1 ≤ k ≤ n ≤ 500
 * −5000 ≤ Node.value ≤ 5000
 *
 * Test cases:
 * [6, 8, 7] , k=1
 * [9, 0, 8, 2] , k=2
 * [1, 2, 3, 4, 5] , k=3
 * [7, 4, 6, 1, 5, 8] , k=5
 * [0, 8, 3, 1, 9, 2, 7] , k=7
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] , k=10
 * [6, 7, 8, 9, 0, 1, 2, 4] , k=4 OR 5
 * [9, 5, 8, 2, 1, 3, 6, 7, 4, 5, 9] , k=8
 * [4, 2, 7, 8, 9, 0, 2] , k=3
 */
public class SwapNodesInLinkedList {

    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        LinkedListNode current = head, nRightNode = head;
        LinkedListNode nLeftNode = null;

        while (k-- > 1) {
            current = current.nextNode;
        }
        nLeftNode = current;
        while (null != current.nextNode) {
            current = current.nextNode;
            nRightNode = nRightNode.nextNode;
        }

        int tempData = nLeftNode.data;
        nLeftNode.data = nRightNode.data;
        nRightNode.data = tempData;

        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        [6, 8, 7] , k=1
//        linkedList.add (6);
//        linkedList.add (8);
//        linkedList.add (7);

//        [9, 0, 8, 2] , k=2
//        linkedList.add (9);
//        linkedList.add (0);
//        linkedList.add (8);
//        linkedList.add (2);

//         [1, 2, 3, 4, 5] , k=3
//        linkedList.add (1);
//        linkedList.add (2);
//        linkedList.add (3);
//        linkedList.add (4);
//        linkedList.add (5);

//        [7, 4, 6, 1, 5, 8] , k=5
//        linkedList.add (7);
//        linkedList.add (4);
//        linkedList.add (6);
//        linkedList.add (1);
//        linkedList.add (5);
//        linkedList.add (8);

//        [0, 8, 3, 1, 9, 2, 7] , k=7
        linkedList.add (0);
        linkedList.add (8);
        linkedList.add (3);
        linkedList.add (1);
        linkedList.add (9);
        linkedList.add (2);
        linkedList.add (7);

        System.out.println("BEFORE : " + linkedList.toString());
        LinkedListNode newLink = swapNodes (linkedList.head, 7);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));

    }
}
