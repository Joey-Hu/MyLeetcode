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

### 树

#### [剑指 Offer 33. 二叉搜索树的后序遍历序列](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

思路：递归+分治

```java
public boolean verifyPostorder(int[] postorder) {
    return recur(postorder, 0, postorder.length-1);

}

private boolean recur(int[] postorder, int start, int end) {
    if (start >= end) {
        return true;
    }

    int i = start;
    // 找到第一个大于根节点的结点，即根节点的右子树节点
    while (postorder[i] < postorder[end]) {
        i ++;
    }
    int mid = i;
    // 判断右子树的结点是不是都是大于根节点
    while (postorder[i] > postorder[end]) {
        i ++;
    }

    return i == end && recur(postorder, start, mid-1) && recur(postorder, mid, end-1);
}
```

### 二分

#### [lc33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

思路：先二分找到最小值所对应的下标 minValIdx，然后规定target可能所在区间的左右边界（minValIdx 的左边还是右边），然后使用二分搜索查找target

```java
public int search(int[] nums, int target) {
    // 找到最小值所在的下标
    int len = nums.length;
    int minIdx = findMinIdx(nums);
    int left = target > nums[len-1] ? 0 : minIdx;
    int right = target > nums[len-1] ? minIdx-1 : len-1;
    return binarySearch(nums, left, right, target);
}

private int findMinIdx(int[] nums) {
    int len = nums.length;
    int low = 0;
    int high = len - 1;

    while (low < high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] > nums[len-1]) {
            low = mid + 1;
        }else {
            high = mid;
        }
    }
    return low;
}

private int binarySearch(int[] nums, int left, int right, int target) {
    int low = left;
    int high = right;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        }else if (nums[mid] < target) {
            low = mid + 1;
        }else if (nums[mid] > target) {
            high = mid - 1;
        }
    }
    return -1;
}
```

### 字符串

#### [lc8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)

思路：注意判断条件 1. 去空格  2. 判断sign  3. 计算res

```java
public int myAtoi(String s) {
    int i = 0;
    int sign = 1;
    int res = 0;

    if (s.length() == 0) {
        return 0;
    }

    // 去掉空格
    while (i < s.length() && s.charAt(i) == ' ') {
        i ++;
    }

    // 如果出现符号字符，仅第 1 个有效，并记录正负
    if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = (s.charAt(i++) == '-') ? -1 : 1;
    }

    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        // 必须先判断res和MAX_VALUE的大小然后再进行res更新，不然会造成res越界，从而造成res值发生错误
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') > Integer
                                             .MAX_VALUE % 10)) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        res = res * 10 + (s.charAt(i++) - '0');
    }
    return res * sign;
}
```

