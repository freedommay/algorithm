package offer;

public class Permutation {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean permutation(String A, String B) {
        int aLen = A.length();
        int blen = B.length();
        if (aLen != blen) return false;
        int[] hash = new int[128];
        for (int i = 0; i < aLen; i++) {
            hash[A.charAt(i)]++;
            hash[B.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
