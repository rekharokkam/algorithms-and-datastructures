package com.learning.basicjava.grokkingthecodinginterviewpattern.util;

public class MyStackWithSinglyLinkedList {

    public LinkedListNode head;
    public LinkedListNode tail;

    public void push (int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (null == head) {
            head = newNode;
        }
        if(null != tail) {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    //will return the Node on top of the list
    public int peek () {
        return tail.data;
    }

    //Will return the Node on top of the list and also remove it.
    public int pop () {
        int tailData = tail.data;
        LinkedListNode current = head, previousNode = null;

        while (true) {
            if (null == current.nextNode) {
                break;
            }
            previousNode = current;
            current = current.nextNode;
        }

        //last element in the stack
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            previousNode.nextNode = null;
            tail = previousNode;
        }
        return tailData;
    }

    public int length () {
        int stackLength = 0;
        LinkedListNode current = head;
        while (null != current) {
            current = current.nextNode;
            stackLength ++;
        }
        return stackLength;
    }

    public boolean empty () {
        return (null == head);
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedListNode current = head;
        while (null != current) {
            sb.append((current != null)? current.data:"");
            sb.append((current.nextNode != null) ? " , " : "");
            current = current.nextNode;
        }
        sb.append("]");
        return sb.toString();
    }
}
