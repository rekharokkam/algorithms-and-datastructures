package com.learning.basicjava.grokkingthecodinginterviewpattern.fastslowpointers;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.LinkedListNode;
import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyLinkedList;

/**
 * Check whether or not a linked list contains a cycle. If a cycle exists, return TRUE. Otherwise, return FALSE. The cycle means that at least one node can be reached again by traversing the next pointer.
 *
 * Constraints:
 * Let n be the number of nodes in a linked list.
 * 0 ≤ n ≤ 500
 * −10 power of 5 ≤ Node.data ≤ 10 power of 5
 *
 * Test cases:
 * Linked List : head -> 2 -> 4 -> 6 -> 8 -> 10 , 10 links back to 4, Ans: true
 * Linked List : head -> 1 -> 3 -> 5 -> 7 -> 9 -> null, Ans: false
 * Linked List : head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6, 6 links back to 4, Ans: true
 *
 */
public class LinkedListCycle {

    public static boolean detectCycle (LinkedListNode headNode) {
        LinkedListNode slow = headNode, fast = headNode;

        //slow jumps by 1 and fast by 2. At some point if they meet, its cyclic.
        do {
//            System.out.println("slow : " + slow.data + "  fast node : " + fast.data);

            if (null != slow && null != fast && null != slow.nextNode
                    && null != fast.nextNode && null != fast.nextNode.nextNode) {
                slow = slow.nextNode;
                fast = fast.nextNode.nextNode;

                if (fast.data == slow.data) {
                    return true;
                }
            } else {
                return false;
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
//        linkedList.cyclicLink(4);


//        linkedList.add (1);
//        linkedList.add (3);
//        linkedList.add (5);
//        linkedList.add (7);
//        linkedList.add (9);

        linkedList.add (1);
        linkedList.add (2);
        linkedList.add (3);
        linkedList.add (4);
        linkedList.add (5);
        linkedList.add (6);
        linkedList.cyclicLink(4);

        System.out.println(linkedList.toString());
        boolean isCyclicNodeExists = detectCycle (linkedList.head);
        System.out.println(isCyclicNodeExists);
    }
}
