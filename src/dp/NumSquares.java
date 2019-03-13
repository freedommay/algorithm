package dp;

import java.util.Arrays;

public class NumSquares {
    /**
     * 给一个正整数 n, 请问最少多少个完全平方数(比如1, 4, 9...)的和等于n。
     * 设 f[i] 表示加和为 i 的最少完全平方数的个数.
     * 状态转移方程: f[i] = min{f[i], f[i - j * j] + 1} (j*j <= i)
     * 边界: f[i*i] = 1
     *
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        int f[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(f, Integer.MAX_VALUE);
        }
        for (int i = 1, k = 1; i <= n; k++, i = k * k) {
            f[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j < i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        return f[n];
    }
}
