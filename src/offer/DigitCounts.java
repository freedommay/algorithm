package offer;

public class DigitCounts {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += count(k, i);
        }
        return 0;
    }

    private int count(int k, int n) {
        int res = 0;
        if (k == 0 && n == 0) {
            return 1;
        }
        while (n != 0) {
            if (n % 10 == k) {
                res++;
            }
            n = n / 10;
         }
        return res;
    }
}
