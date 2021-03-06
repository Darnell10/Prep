package com.company.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time : O(1) , Space O(m)
 */
public class MaxStack {

    public static void main(String[] args) {


    }

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> max = new ArrayDeque<>();
    private Deque<Integer> min = new ArrayDeque<>();

    // Add a new item to the top of our stack. If the item is greater
    // than or equal to the last item in maxesStack, it's
    // the new max! So we'll add it to maxesStack.

    public void push(int item) {
        stack.push(item);
        if (max.isEmpty() || item >= max.peek()) {
            max.push(item);
        }
        if (min.isEmpty() || item <= min.peek()) {
            min.push(item);
        }

    }

    // Remove and return the top item from our stack. If it equals
    // the top item in maxesStack, they must have been pushed in together.
    // So we'll pop it out of maxesStack too.

    public int pop() {
        int item = stack.pop();
        if (item == max.peek()) {
            max.pop();
        }
        if (item == min.peek()) {
            min.pop();
        }
        return item;
    }

    // The last item in maxesStack is the max item in our stack.
    public int getMax() {
        return max.pop();
    }

    public int getMin() {
        return min.pop();
    }

}
