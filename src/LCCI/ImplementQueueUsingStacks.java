package LCCI;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/6 13:57
 * @desc: https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 */
public class ImplementQueueUsingStacks {
    /**
     * 用两个栈来模拟队列，一个用来压入stackPush，一个用来弹出stackPop，入栈有两个条件：
     * 1. 当stackPop非空是，stackPush不能压入数据
     * 2. stackPush必须一次性压入全部数据
     */
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void pushToStack(){
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.push(x);
        pushToStack();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        pushToStack();
        return stackPop.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        pushToStack();
        return stackPop.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            return true;
        }
        return false;
    }
}
