package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /**
     * @param num:    Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> results = new ArrayList<>();
        if (num.length == 0) {
            return results;
        }
        List<Integer> comb = new ArrayList<>();
        dfs(num, 0, comb, target, results);
        return results;
    }

    private void dfs(int[] num, int startIndex, List<Integer> comb,
                     int target, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(comb));

        }
        for (int i = startIndex; i < num.length; i++) {
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            if (target < num[i]) {
                break;
            }
            comb.add(num[i]);
            dfs(num, i + 1, comb, target - num[i], results);
            comb.remove(comb.size() - 1);
        }
    }
}
