package list;

public class MergeSortedArray2 {
    /**
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int pos = m + n - 1;
        int aPtr = m - 1, bPtr = n - 1;
        while (m >= 0 && n >= 0) {
            if (A[aPtr] >= B[bPtr]) {
                A[pos--] = A[aPtr--];
            } else {
                A[pos--] = B[bPtr--];
            }
        }
        while (bPtr >= 0) {
            A[pos--] = B[bPtr--];
        }
    }
}
