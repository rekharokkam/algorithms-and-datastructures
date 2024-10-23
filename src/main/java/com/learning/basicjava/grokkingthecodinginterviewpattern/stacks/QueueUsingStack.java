package com.learning.basicjava.grokkingthecodinginterviewpattern.stacks;

import com.learning.basicjava.grokkingthecodinginterviewpattern.util.MyStackWithSinglyLinkedList;

/**
 * Design a custom queue, MyQueue, using only two stacks. Implement the Push(), Pop(), Peek(), and Empty() methods:
 *
 * Void Push(int x): Pushes element at the end of the queue.
 * Int Pop(): Removes and returns the element from the front of the queue.
 * Int Peek(): Returns the element at the front of the queue.
 * Boolean Empty(): Returns TRUE if the queue is empty. Otherwise FALSE.
 * You are required to only use the standard stack operations, which means that only the Push() to top, Peek() and Pop() from the top, Size(), and Is Empty() operations are valid.
 *
 * Note: In some interview questions, Void Push(int x) and Int Pop() might be referred to as Void Enqueue(int x) and Int Dequeue(), respectively.
 *
 * Constraints:
 *
 * 1<= x <= 100
 * A maximum of 100 calls can be made to Push(), Pop(), Peek(), and Empty().
 * The Pop() and Peek() methods will always be called on non-empty stacks.
 *
 * Test cases:
 * push(1), push(2), peek(1), pop(), empty()
 * pop(), push(2), peek(1), pop(), empty()
 * push(1), pop(), push(2), peek(), empty()
 * push(10), push(20), pop(), peek()
 * push(10), pop(), pop(), empty()
 * push(10), push(20), push(30), pop(), peek(), pop()
 *
 */
public class QueueUsingStack {

    private MyStackWithSinglyLinkedList stack1 = new MyStackWithSinglyLinkedList(),
            stack2 = new MyStackWithSinglyLinkedList();

    public void push (int data) {
        stack1.push(data);
    }

    public int pop () {
        if (stack2.empty()) {
            transferData ();
        }
        return stack2.pop();
    }

    public int peek () {
        if (stack2.empty()) {
            transferData ();
        }
        return stack2.peek();
    }

    public boolean empty () {
        return (stack1.empty() && stack2.empty());
    }

    private void transferData () {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    public String toString (){
        StringBuilder sb = new StringBuilder();
        if (null != stack1.head) {
            sb.append(stack1.toString());
            sb.append(" ");
        }
        if (null != stack2.head) {
            sb.append(stack2.toString());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        QueueUsingStack myQueue = new QueueUsingStack();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        myQueue.push(40);

        System.out.println("before popping : " + myQueue.toString());

        System.out.println("popping 1 " + myQueue.pop());
        System.out.println("popping 2 " + myQueue.pop());
        System.out.println("popping 3 " + myQueue.pop());
//        System.out.println("popping 4 " + myQueue.pop());
        myQueue.push(50);
        myQueue.push(60);
        myQueue.push(70);
        System.out.println("popping 4 " + myQueue.pop());
        System.out.println("popping 5 " + myQueue.pop());
        System.out.println("after popping : " + myQueue.toString());

    }
}
