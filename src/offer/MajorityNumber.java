package offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityNumber {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        int size = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int value = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            if (map.get(key) > size / 2) {
                value = key;
                break;
            }
        }
        return value;
    }
}
