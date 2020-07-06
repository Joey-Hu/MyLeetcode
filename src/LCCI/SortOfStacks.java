package LCCI;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/7/6 14:23
 * @desc: https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 */
public class SortOfStacks {
    /**
     * 入栈操作
     * while(要入栈的元素x值大于栈顶元素时）
     *     先将栈顶元素放到辅助栈中
     * x入data栈
     *
     * while(辅助栈非空)
     *     将辅助栈中的元素放入data栈中
     */

    private Stack<Integer> data;
    private Stack<Integer> helper;


    public SortOfStacks() {
        data = new Stack<Integer>();
        helper = new Stack<Integer>();
    }

    public void push(int val) {
        if(!data.isEmpty() && data.peek() < val){
            while (!data.isEmpty() && data.peek() < val){
                helper.push(data.pop());
            }
            data.push(val);
            while (!helper.isEmpty()){
                data.push(helper.pop());
            }
        }else{
            data.push(val);
        }
    }

    public void pop() {
        if(data.isEmpty()){
            return;
        }else{
            data.pop();
        }
    }

    public int peek() {
        if (data.isEmpty()){
            return -1;
        }else {
            return data.peek();
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
