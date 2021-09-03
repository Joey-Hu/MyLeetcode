### 回溯

#### [lc37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/)

```java
public void solveSudoku(char[][] board) {
    backtrack(board, 0, 0);
}

private boolean backtrack(char[][] board, int r, int c) {
    int m = 9;
    int n = 9;

    // 终止条件
    // 穷举到最后一列，换到下一行重新开始
    if (c == n) {
        return backtrack(board, r+1, 0);
    }
    if (r == m) {
        return true;
    } 

    for (int i = r; i < m; i ++) {
        for (int j = c; j < n; j ++) {
            // 如果有预设数字，则继续往后遍历
            if (board[i][j] != '.') {
                return backtrack(board, i, j+1);
            }

            for (char ch = '1'; ch <= '9'; ch ++) {
                if (!isValid(board, i, j, ch)) {
                    continue;
                }
                board[i][j] = ch;
                if (backtrack(board, i, j+1)) {
                    return true;
                }
                board[i][j] = '.';
            }
            // 穷举完1~9，亦然没有可行解，此路不通
            return false;
        }
    }
    return false;
}

private boolean isValid(char[][] board, int r, int c, char ch) {
    for (int i = 0; i < 9; i ++) {
        // 行存在重复
        if (board[r][i] == ch) {
            return false;
        }
        // 列存在重复
        if (board[i][c] == ch) {
            return false;
        }
        // 九宫格存在重复
        if (board[(r/3)*3+i/3][(c/3)*3+i%3] == ch) {
            return false;
        }
    }
    return true;
}
```

### 栈

#### [lc224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator/)

```java
public int calculate(String s) {

    Stack<Integer> stack = new Stack();

    int result = 0;
    int sign = 1;
    int number = 0;

    for (int i = 0; i < s.length(); i ++) {
        char ch = s.charAt(i);
        if (ch >= '0' && ch <= '9') {
            number = number*10 + (int)(ch-'0');
        }else if (ch == '+') {
            // 遇到+和-，汇总result，并且number置为0，注意sign的区别
            result += sign * number;
            sign = 1;
            number = 0;
        }else if (ch == '-') {
            result += sign * number;
            sign = -1;
            number = 0;
        }else if (ch == '(') {
            stack.push(result);
            stack.push(sign);
            result = 0;
            sign = 1;
        }else if (ch == ')') {
            result += sign * number;
            number = 0;
            result *= stack.pop();
            result += stack.pop();
        }
    }

    if (number != 0) {
        result += sign * number;
    }

    return result;
}
```

### 数组

#### [lc41 缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/)（记住吧、、、）

思路：原地hash

1. 我们要找的数就在 [1, N + 1] 里，最后 N + 1 这个元素我们不用找。因为在前面的 N 个元素都找不到的情况下，我们才返回 N + 1；
   那么，我们可以采取这样的思路：就把 1 这个数放到下标为 0 的位置， 2 这个数放到下标为 1 的位置，按照这种思路整理一遍数组。然后我们再遍历一次数组，第 1 个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数。
   这个思想就相当于我们自己编写哈希函数，这个哈希函数的规则特别简单，那就是数值为 i 的数映射到下标为 i - 1 的位置。

```java
public int firstMissingPositive(int[] nums) {
    int len = nums.length;

    for (int i = 0; i < len; i ++) {
        // 将满足1到len之间的数字放到指定的位置上，比如1放到index为0的位置，2放到index为1的位置
        while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1] != nums[i]) {
            swap(nums, nums[i]-1, i);
        }
    }

    for (int i = 0; i < len; i ++) {
        // 找到第一个“不正确”元素，返回
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }
    // 如果都正确，返回len+1
    return len + 1;
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```

### 位运算

#### [191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/)

思路：逐位右移判断，和1交运算

```java
public int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
        res += n & 1;
        n = n >>> 1;
    }
    return res;
}
```

