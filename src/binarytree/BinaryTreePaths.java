package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, String.valueOf(root.val));
        return result;
    }

    private void helper(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, result, path + "->" + root.left.val);
        }
        if (root.right != null) {
            helper(root.right, result, path + "->" + root.right.val);
        }
    }
}
