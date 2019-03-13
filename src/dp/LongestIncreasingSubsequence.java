package dp;

import java.util.TreeSet;

public class LongestIncreasingSubsequence {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        int result[] = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[j] + 1, result[i]);
                }
            }
        }
        int max = result[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public int longestIncreasingSubsequence2(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i : nums) {
            Integer ceil = set.ceiling(i);

            if (ceil != null) {
                set.remove(ceil);
            }

            set.add(i);
        }

        return set.size();
    }
}
