package list;

public class WinSum {
    /**
     * @param nums: a list of integers.
     * @param k:    length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] sum = new int[len];
        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i + k - 1] - nums[i - 1];
        }
        return sum;
    }
}
