package com.learning.basicjava.grokkingthecodinginterviewpattern.inplacemanipulation;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyStack;

public class ImplementingStackWithLinkedList {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push (9);
        myStack.push (0);
        myStack.push (8);
        myStack.push (2);
        myStack.push (1);

        System.out.println("Original Stack : " + myStack);
        System.out.println("Original Stack length: " + myStack.length());

        System.out.println("\n");

        System.out.println("Peeking : " + myStack.peek() );
        System.out.println("Length of the stack before popping : " + myStack.length());
        System.out.println("Pop : " + myStack.pop() );
        System.out.println("Length of the stack after popping : " + myStack.length());
        System.out.println("After Peek and Pop Operations : " + myStack);

        System.out.println("\n");

        System.out.println("Peekinging again : " + myStack.peek() );
        System.out.println("Length of the stack before popping again : " + myStack.length());
        System.out.println("Popping again : " + myStack.pop() );
        System.out.println("Length of the stack after popping again : " + myStack.length());
        System.out.println("After Peek and Pop Operations again : " + myStack);
    }
}
