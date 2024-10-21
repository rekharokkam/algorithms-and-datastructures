package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyQueue;

public class ImplementingQueueWithLinkedList {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push (9);
        myQueue.push (0);
        myQueue.push (8);
        myQueue.push (2);
        myQueue.push (1);

        System.out.println("Original Stack : " + myQueue);
        System.out.println("Original Stack length: " + myQueue.length());

        System.out.println("\n");

        System.out.println("Peeking : " + myQueue.peek() );
        System.out.println("Length of the stack before popping : " + myQueue.length());
        System.out.println("Pop : " + myQueue.pop() );
        System.out.println("Length of the stack after popping : " + myQueue.length());
        System.out.println("After Peek and Pop Operations : " + myQueue);

        System.out.println("\n");

        System.out.println("Peekinging again : " + myQueue.peek() );
        System.out.println("Length of the stack before popping again : " + myQueue.length());
        System.out.println("Popping again : " + myQueue.pop() );
        System.out.println("Length of the stack after popping again : " + myQueue.length());
        System.out.println("After Peek and Pop Operations again : " + myQueue);
    }
}
