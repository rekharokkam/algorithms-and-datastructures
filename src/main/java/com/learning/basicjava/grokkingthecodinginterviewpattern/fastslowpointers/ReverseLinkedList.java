package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

public class ReverseLinkedList {

    public static LinkedListNode revereLinkedList (LinkedListNode head) {
        if (null == head.nextNode) { //list consists of only 1 element
            return head;
        }

        LinkedListNode previous = head, current = head.nextNode, next = current.nextNode;
        head.nextNode = null;

        if (null == next) { //only 2 elements in the list
            next = current;
            current.nextNode = previous;
            head = current;
            return head;
        }

        do {
            current.nextNode = previous;
            previous = current;
            current = next;
            next = current.nextNode;

        } while (null != next);
        current.nextNode = previous;
        head = current;
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add (2);
        linkedList.add (4);
        linkedList.add (6);
        linkedList.add (8);
        linkedList.add (10);

        System.out.println("BEFORE : " + linkedList.toString());
        linkedList.tail = linkedList.head;
        LinkedListNode newLink = revereLinkedList (linkedList.head);
        System.out.println("AFTER : " + MyLinkedList.nonCyclictoString(newLink));
    }
}
