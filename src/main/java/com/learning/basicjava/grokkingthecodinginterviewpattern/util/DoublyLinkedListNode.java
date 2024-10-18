package com.learning.basicjava.grokkingthecodinginterviewpattern.util;

public class DoublyLinkedListNode {

    int data;
    DoublyLinkedListNode previousNode;
    DoublyLinkedListNode nextNode;

    public DoublyLinkedListNode () { }

    public DoublyLinkedListNode (int data, DoublyLinkedListNode previousNode,
                                 DoublyLinkedListNode nextNode) {
        this.data = data;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }
    public DoublyLinkedListNode (int data) {
        this.data = data;
    }
}
