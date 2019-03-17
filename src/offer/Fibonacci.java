package offer;

import java.util.*;

public class Fibonacci {
    /**
     * @param n: an integer
     * @return: an integer f(n)
     */
    private Map<Integer, Integer> cache = new HashMap<>();
    public int fibonacci(int n) {
        cache.put(1, 0);
        cache.put(2, 1);
        return fibonacciHelp(n);
    }
    private int fibonacciHelp(int n) {
        if (cache.get(n) != null) return cache.get(n);
        else {
            cache.put(n, fibonacciHelp(n - 1) + fibonacciHelp(n - 2));
        }
        return cache.get(n);
    }

    public int fibonacci2(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int fibN = 0, fibMinusOne = 1, fibMinusTwo = 0;
        for (int i = 3; i <= n; i++) {
            fibN = fibMinusOne + fibMinusTwo;
            fibMinusTwo =  fibMinusOne;
            fibMinusOne = fibN;
        }
        return fibN;
    }
}
