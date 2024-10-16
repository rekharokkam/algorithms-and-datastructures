package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

public class ReverseLinkedList {

    public static LinkedListNode revereLinkedList (LinkedListNode head) {
        LinkedListNode previous = null, current = head, next = null;

        do {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;

            current = (null != next) ? next : current;

        } while (null != next);
        head = current;
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

//        linkedList.add (2);
//        linkedList.add (4);
//        linkedList.add (6);
//        linkedList.add (8);
//        linkedList.add (10);

//        linkedList.add(1);
//        linkedList.add(3);
//        linkedList.add(5);
//        linkedList.add(7);
//        linkedList.add(9);
//        linkedList.add(11);

        linkedList.add(16);
//        linkedList.add(15);

        System.out.println("BEFORE : " + linkedList.toString());
        linkedList.tail = linkedList.head;
        LinkedListNode newLink = revereLinkedList (linkedList.head);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));
    }
}
