package huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FaMa {
    /**
     *
     * @param n  砝码的种类
     * @param weight  每种砝码的重量
     * @param nums  每种砝码的数量
     * @return  能称出的不同重量
     */
    private static int fama(int n, int[] weight, int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(set);
            for (int j = 1; j <= nums[i]; j++) {
                for (int k = 0; k < list.size(); k++) {
                    set.add(list.get(k) + j * weight[i]);
                }
            }
        }
        return set.size();
    }
}
