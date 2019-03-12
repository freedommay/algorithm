package twopointer;

public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return 0;
        int left = 0, right = len - 1;
        while (left <= right) {
            while (left < len && nums[left] < k) left++;
            if (left == len - 1) return len;
            while (right >= 0 && nums[right] >= k) right--;
            if (left < right) {
                swap(nums, left++, right--);
            }
        }
        return ++right;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
