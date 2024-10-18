package com.learning.basicjava.grokkingthecodinginterviewpattern.util;

public class MyQueue {

    LinkedListNode head, tail;

    public void push (int data) {
        LinkedListNode newNode = new LinkedListNode(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    public int peek () {
        return head.data;
    }

    public int pop () {
        int headData = head.data;
        head = head.nextNode;
        return headData;
    }

    public int length () {
        int queueLength = 0;
        LinkedListNode next = head;
        while (null != next) {
            queueLength ++;
            next = next.nextNode;
        }
        return queueLength;
    }

    @Override
    public String toString (){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedListNode node = head;
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
