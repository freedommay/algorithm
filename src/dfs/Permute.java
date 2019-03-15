package dfs;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        dfs(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, boolean[] visited,
                     List<Integer> permutation, List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
