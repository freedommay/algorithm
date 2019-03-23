package offer;

public class SearchRange {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int len = A.length;
        if (len == 0) {
            return new int[]{-1, 1};
        }

        int start = searchStart(A, 0, len - 1, target);
        int end = searchEnd(A, 0, len - 1, target);
        return new int[] {start, end};
    }

    private int searchStart(int[] A, int start, int end, int target) {
        int a, b;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) return start;
        else if (A[end] == target) return end;
        else return -1;
    }

    private int searchEnd(int[] A, int start, int end, int target) {
        int a, b;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) return end;
        else if (A[start] == target) return start;
        else return -1;
    }
}
