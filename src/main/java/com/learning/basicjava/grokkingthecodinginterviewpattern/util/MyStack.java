package com.learning.basicjava.grokkingthecodinginterviewpattern.util;

/**
 * I am using a doubly linked list
 */
public class MyStack {

    public DoublyLinkedListNode tail;
    public DoublyLinkedListNode head;

    public void push (int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (null == head) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
            DoublyLinkedListNode temp = tail;
            newNode.previousNode = temp;
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
        DoublyLinkedListNode tailPrevious = tail.previousNode;
        tailPrevious.nextNode = null;
        tail = tailPrevious;
        return tailData;
    }

    public int length () {
        int stackLength = 0;
        DoublyLinkedListNode node = head;
        while (null != node) {
            node = node.nextNode;
            stackLength ++;
        }
        return stackLength;
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DoublyLinkedListNode node = head;
        do {
            sb.append((node != null)? node.data:"");
            if (tail.data == node.data){
                break;
            }
            sb.append((node.nextNode != null) ? " , " : "");
            node = node.nextNode;
        } while (true);

        sb.append("]");
        return sb.toString();
    }
}
