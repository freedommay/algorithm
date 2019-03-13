package twopointer;

import java.util.*;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int a = 0; a < len; a++) {
            for (int b = a + 1, c = len - 1; b < c;) {
                if (numbers[a] + numbers[b] + numbers[c] == 0) {
                    List<Integer> list = Arrays.asList(numbers[a], numbers[b], numbers[c]);
                    result.add(list);
                }
                if (numbers[a] + numbers[b] + numbers[c] < 0) {
                    b++;
                } else {
                    c--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
