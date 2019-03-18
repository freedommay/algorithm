package offer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        helper(root, paths, new ArrayList<>(), 0, target);
        return paths;
    }

    private void helper(TreeNode treeNode, List<List<Integer>> paths, List<Integer> path, int sum, int target) {
        if (treeNode.left == null && treeNode.right == null) {
            if (sum + treeNode.val == target) {
                path.add(treeNode.val);
                paths.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        if (treeNode.left != null) {
            path.add(treeNode.val);
            helper(treeNode.left, paths, path, sum + treeNode.val, target);
            path.remove(path.size() - 1);
        }
        if (treeNode.right != null) {
            path.add(treeNode.val);
            helper(treeNode.right, paths, path, sum + treeNode.val, target);
            path.remove(path.size() - 1);
        }
    }
}
