package com.company.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class TwoStacksOneQueue {

    public static void main(String[] args) {
    }

    /**Time complexity O(1)*/
    private final Deque<Integer> inStack = new ArrayDeque<>();
    private final Deque<Integer> outStack = new ArrayDeque<>();

    public void enqueue(int item) {
        inStack.push(item);
    }


    public int dequeue() {

        if (outStack.isEmpty()) {
            // move items from inStack to outStack, reversing order
            while (!inStack.isEmpty()) {
                int newestInStackItem = inStack.pop();
                outStack.push(newestInStackItem);
            }

            // if outStack is still empty, raise an error
            if (outStack.isEmpty()) {
                throw new NoSuchElementException("Can't Dequeue empty Queue");
            }
        }

        return outStack.pop();
    }

}
