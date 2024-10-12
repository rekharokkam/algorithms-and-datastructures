package com.learning.basicjava.grokkingthecodinginterviewpattern.util;

public class MyLinkedList extends LinkedListNode {

    public LinkedListNode head;
    public LinkedListNode tail;

    public void add (int data) {
        LinkedListNode newNode = new LinkedListNode (data);
        if (null == head) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
        tail = newNode;
    }

    public void cyclicLink (int toData) {
        LinkedListNode cyclicNode = head.nextNode;
        while (null != cyclicNode) {
            if (cyclicNode.data == toData) {
                tail.nextNode = cyclicNode;
                break;
            }
            cyclicNode = cyclicNode.nextNode;
        }
    }

    public static String nonCyclictoString (LinkedListNode head){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        LinkedListNode node = head;
        do {
            sb.append((node != null)? node.data:"");
            if (null == node){
                break;
            }
            sb.append((node.nextNode != null) ? " , " : "");
            node = node.nextNode;
        } while (true);

        sb.append("]");
        return sb.toString();
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
