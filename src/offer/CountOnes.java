package offer;

public class CountOnes {
    /**
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        int ones = 0;
        int flag = 1;
        while (flag != 0) {
            if ((num & flag) != 0) ones++;
            flag <<= 1;
        }
        return ones;
    }
}
