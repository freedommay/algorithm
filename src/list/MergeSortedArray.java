package list;

public class MergeSortedArray {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;
        int[] result = new int[aLen + bLen];
        int aPtr = 0, bPtr = 0;
        int pos = 0;
        while (aPtr != aLen && bPtr != bLen) {
            if (A[aPtr] < B[bPtr]) {
                result[pos++] = A[aPtr++];
            } else {
                result[pos++] = B[bPtr++];
            }
        }
        while (aPtr != aLen) {
            result[pos++] = A[aPtr++];
        }
        while (bPtr != bLen) {
            result[pos++] = B[bPtr++];
        }

        return result;
    }
}
