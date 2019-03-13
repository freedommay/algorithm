package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] f = new int[len];
        int[] pre = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            pre[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    pre[i] = j;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int max = 0;
        int max_i = 0;
        for (int i = 0; i < len; i++) {
            if (f[i] > max) {
                max = f[i];
                max_i = i;
            }
        }
        result.add(nums[max_i]);
        while (max_i != pre[max_i]) {
            max_i = pre[max_i];
            result.add(nums[max_i]);
        }
        Collections.reverse(result);
        return result;
    }
}
