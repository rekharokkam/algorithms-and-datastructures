package com.learning.basicjava.grokkingthecodinginterviewpattern.twopointers;

public class LinkedListNode {
    public int data;
    public LinkedListNode nextNode;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode(int data, LinkedListNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public LinkedListNode() {
    }
}
