package twopointer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i;
                break;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        int[] result = new int[2];
        Pair[] number = new Pair[len];
        for (int i = 0; i < len; i++) {
            number[i] = new Pair(numbers[i], i);
        }
        Arrays.sort(number, new ValueComparator());
        int left = 0, right = len - 1;
        while (left < right) {
            if (number[left].getValue() + number[right].getValue() == target) {
                int t1 = number[left].index;
                int t2 = number[right].index;
                result[0] = Math.min(t1, t2);
                result[1] = Math.max(t1, t2);
                break;
            }
            if (number[left].getValue() + number[right].getValue() < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
    class ValueComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }

    class Pair {
        Integer value;
        Integer index;

        Pair(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        Integer getValue() {
            return this.value;
        }
    }
}
