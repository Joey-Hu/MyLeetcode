package LCCI;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author: huhao
 * @time: 2020/7/5 10:19
 * @desc: https://leetcode-cn.com/problems/stack-of-plates-lcci/
 */
public class StackOfPlates {
    /**
     * 1. 实现动态增加stack，使用List<Stack<Integer>>
     * 2. push(): 获取最后一个stack的size是否大于capacity，若是，新建stack，push，并add到list中
     * 3. pop(): 由popAt(list.size()-1)实现
     * 4. popAt(index): 通过list拿到指定index的栈，拿到之后执行stack的pop操作。如果弹出栈顶元素之后，当前stack变成空了，
     * 需要将当前stack从list中移除。
     */
    private List<Stack<Integer>> stackList;
    private int cap;

    public StackOfPlates(int cap) {
        stackList = new ArrayList<>();
        this.cap = cap;
    }

    public void push(int val) {
        if (cap <= 0) {
            return;
        }

        if (stackList.isEmpty() || stackList.get(stackList.size() - 1).size() == cap) {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            stackList.add(stack);
            return;
        }

        stackList.get(stackList.size() - 1).push(val);
    }

    public int pop() {
        return popAt(stackList.size() - 1);
    }

    public int popAt(int index) {
        if (index < 0 || index >= stackList.size()) {
            return -1;
        }

        Stack<Integer> stack = stackList.get(index);
        if (stack.isEmpty()) {
            return -1;
        }

        int res = stack.pop();

        if (stack.isEmpty()) {
            stackList.remove(index);
        }

        return res;
    }
}
