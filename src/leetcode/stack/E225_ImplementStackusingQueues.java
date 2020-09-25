package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/9/25 19:42
 * @desc: https://leetcode.com/problems/implement-stack-using-queues/
 */
class MyStack {

    private Queue<Integer> queue;
    private int topElement;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        // record the top element
        topElement = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = queue.size();
        // push the elements again except last one
        while (size >= 1) {
            topElement = queue.poll();
            queue.offer(topElement);
            size --;
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return topElement;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
