package offer;

public class SingleNumber {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        int len = A.length;
        int result = A[0];
        for (int i = 1; i < len; i++) {
            result ^= A[i];
        }
        return result;
    }
}
