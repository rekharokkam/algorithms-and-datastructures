package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers.ReverseLinkedList;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

public class ReverseLinkedListInBetween {

    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        LinkedListNode leftNode = head, rightNode = null, next = head, previousToLeft = head;
        int initialCounter = 1;
        int difference = right - left;
        while (initialCounter++ < left) {
            previousToLeft = next;
            next = next.nextNode;
        }
        leftNode = next;
        initialCounter = 0;
        while (initialCounter++ < difference) {
            next = next.nextNode;
        }
        rightNode = next;
        next = next.nextNode;

        //create a sub-array
        if (!leftNode.equals(previousToLeft)) {
            previousToLeft.nextNode = null;
        }
        rightNode.nextNode = null;

        LinkedListNode reversedNode = ReverseLinkedList.revereLinkedList(leftNode);
        previousToLeft.nextNode = reversedNode;
        leftNode.nextNode = next;

        if (left == 1) {
            head = reversedNode;
        }
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        6, 8, 7  , left = 1, right = 2
//        linkedList.add (6);
//        linkedList.add (8);
//        linkedList.add (7);

//        9, 0, 8, 2 , left = 2, right = 4
//        linkedList.add (9);
//        linkedList.add (0);
//        linkedList.add (8);
//        linkedList.add (2);

//        1, 2, 3, 4, 5  , left = 1, right = 5
//        linkedList.add (1);
//        linkedList.add (2);
//        linkedList.add (3);
//        linkedList.add (4);
//        linkedList.add (5);

//        7, 4, 6, 1, 5, 8   , left = 2, right = 5
//        linkedList.add (7);
//        linkedList.add (4);
//        linkedList.add (6);
//        linkedList.add (1);
//        linkedList.add (5);
//        linkedList.add (8);


        linkedList.add (0);
        linkedList.add (8);
        linkedList.add (3);
        linkedList.add (1);
        linkedList.add (9);
        linkedList.add (2);
        linkedList.add (7);
        linkedList.add (5);

        System.out.println("BEFORE : " + linkedList.toString());
        LinkedListNode newLink = reverseBetween (linkedList.head, 1, 6);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));
    }
}
