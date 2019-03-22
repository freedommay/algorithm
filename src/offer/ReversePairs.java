package offer;

public class ReversePairs {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        return mergeSort(A, 0, A.length - 1);
    }

    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int sum = 0;
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid + 1, end);
        sum += merge(A, start, mid, end);
        return sum;
    }

    private int merge(int[] A, int start, int mid, int end) {
        int[] copy = new int[A.length];
        int left = start;
        int right = mid + 1;
        int index = start;
        int sum = 0;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                copy[index++] = A[left++];
            } else {
                copy[index++] = A[right++];
                sum += mid - left + 1;
            }
        }
        while (left <= mid) {
            copy[index++] = A[left++];
        }
        while (right <= end) {
            copy[index++] = A[right++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = copy[i];
        }
        return sum;
    }
}
