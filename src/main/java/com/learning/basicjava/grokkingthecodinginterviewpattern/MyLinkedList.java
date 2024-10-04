package com.learning.basicjava.grokkingthecodinginterviewpattern;

public class MyLinkedList extends LinkedListNode {

    LinkedListNode head;
    LinkedListNode tail;

    public void add (int data) {
        LinkedListNode newNode = new LinkedListNode (data);
        if (null == head) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedListNode node = head;
        do {
            sb.append((node != null)? node.data:"");
            sb.append((node.nextNode != null) ? " , " : "");
            node = node.nextNode;
        } while (null != node);

        sb.append("]");
        return sb.toString();
    }

}
