package dp;

public class CanJump {
    /**
     * 给出一个非负整数数组，你最初定位在数组的第一个位置
     * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　\
     * 判断你是否能到达数组的最后一个位置
     *
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        int len = A.length;
        boolean can[] = new boolean[len];
        can[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && A[j] + j >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[len - 1];
    }
}
