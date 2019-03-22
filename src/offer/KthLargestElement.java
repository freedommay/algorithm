package offer;

import java.util.*;

public class KthLargestElement {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        Queue<Integer> q = new PriorityQueue<>(n);
        for (int num: nums) {
            q.offer(num);

            if (q.size() > n) {
                q.poll();
            }
        }
        return q.peek();
    }
}
