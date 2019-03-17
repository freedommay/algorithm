package offer;

public class PartitionArray {
    /**
     * 分割一个整数数组，使得奇数在前偶数在后。
     *
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        int len = nums.length;
        for (int left = 0, right = len - 1; left < right; ) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right++;
            }
            swap(nums, left, right);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
