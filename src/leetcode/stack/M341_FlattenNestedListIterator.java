package leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/9/24 11:12
 * @desc: https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class M341_FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public M341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size()-1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (stack.peek().isInteger()) {
                return true;
            }
            NestedInteger curList = stack.pop();
            for (int i = curList.getList().size()-1; i >= 0 ; i--) {
                stack.push(curList.getList().get(i));
            }
        }
        return false;
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();

    }
}
