#### [lc470 用 rand7() 实现 rand10()](https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/yong-rand7-shi-xian-rand10-by-leetcode/)

```java
public int rand10() {
    int row, col, idx;
    do {
        row = rand7();
        col = rand7();
        idx = col + (row - 1) * 7;
    } while (idx > 40);
    return 1 + (idx - 1) % 10;
}
```

#### [lc458. 可怜的小猪](https://leetcode-cn.com/problems/poor-pigs/)

思路：https://leetcode-cn.com/problems/poor-pigs/solution/hua-jie-suan-fa-458-ke-lian-de-xiao-zhu-by-guanpen/

#### [lc50. Pow(x, n)](https://leetcode-cn.com/problems/powx-n/)

思路：本题是快速幂的题型，叫做快速幂算法，有递归和迭代两个版本。

**快速幂+递归**

要求$x^{n}$ ，可以先递归计算$y = x^{\lfloor n/2 \rfloor}$ ， 然后判断n的奇偶性，如果n是奇数，则$x^{n} = y^{2}$，如果n是偶数，则$x^{n} = y^{2} * x$，递归的边界是当$n = 0$时，返回1。

时间复杂度：O(log n)，即递归的层数；

空间复杂度：O(log n)，即为递归的层数。递归的函数调用会使用栈空间。

**快速幂+迭代**

因为递归会使用栈空间，可以尝试使用迭代方法降低空间复杂度。要求$x^{n}$ ，我们将整数n进行二进制拆分，$n = 2^{i_{0}} + 2^{i_{1}} + ... + 2^{i_{k}}$，那么$x^{n} = 2^{i_{0}} \times 2^{i_{1}} \times ... \times 2^{i_{k}}$，所以，我们只需要获得n的第k二进制位为1，然后将对应的$2^{i_{k}}$乘入答案即可。

时间复杂度：O(log n)，即对n进行二进制拆分的时间复杂度；

空间复杂度：O(1)。

```java
// 快速幂 + 递归
public double myPow(double x, int n) {
    // 转为long是因为测试用例中有-2147483648
    long N = n;
    return N > 0 ? quickMul(x, N) : 1.0/quickMul(x, -N);
}

private double quickMul(double x, long N) {
    if (N == 0) {
        return 1;
    }

    double y = quickMul(x, N/2);
    return N % 2 == 1 ? y * y * x : y * y;
}

// 快速幂 + 迭代
public double myPow(double x, int n) {
    long N = n;
    return N > 0 ? quickMul(x, N) : 1.0/quickMul(x, -N);
}

private double quickMul(double x, long N) {
    double ans = 1;
    double x_contri = x;

    while (N > 0) {
        if (N % 2 == 1) {
            // 如果 N 二进制表示的最低位为 1，那么需要乘入结果
            ans = ans * x_contri;
        }
        // 更新x_contri
        x_contri = x_contri * x_contri;
        N = N / 2;
    }
    return ans;
}
```

#### [lc372. 超级次方](https://leetcode-cn.com/problems/super-pow/)

思路：**快速幂题型**，具体思路参考[超级次方](https://leetcode-cn.com/problems/super-pow/solution/chao-ji-ci-fang-by-leetcode-solution-ow8j/)

```java
static final int MOD = 1337;

public int superPow(int a, int[] b) {
    int ans = 1;
    for (int i = b.length-1; i >= 0; i --) {
        ans = (int)((long) ans * pow(a, b[i]) % MOD);
        a = pow(a, 10);
    }
    return ans;
}

private int pow(int x, int n) {
    // 快速幂
    if (n == 0) {
        return 1;
    }
    int y = (int)((long)pow(x, n/2) % MOD);
    return n % 2 == 1 ? (int)((long)y * y * x % MOD) : (int)((long)y * y % MOD);
}
```

