package list;

public class MaxSubArray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minsum = 0;
        for (int i = 0; i < len; i++) {
             sum += nums[i];
             max = Math.max(max, sum - minsum);
             minsum = Math.min(minsum, sum);
        }
        return max;
    }
}
