package leetcode.stack;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/6 14:40
 * @desc: https://leetcode.com/problems/implement-queue-using-stacks/
 */
class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!in.empty()) {
            out.push(in.pop());
        }

        int res = out.pop();
        while (!out.empty()) {
            in.push(out.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while (!in.empty()) {
            out.push(in.pop());
        }
        int res = out.peek();
        while (!out.empty()) {
            in.push(out.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty();
    }
}
