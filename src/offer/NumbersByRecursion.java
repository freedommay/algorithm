package offer;

import java.util.ArrayList;
import java.util.List;

public class NumbersByRecursion {
    /**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        List<Integer> result = new ArrayList<>();
        helper(n, 0, result);
        return result;
    }

    private void helper(int n, int number, List<Integer> result) {
        if (n == 0) {
            if (number > 0) {
                result.add(number);
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            helper(n - 1, number * 10 + i, result);
        }
    }
}
