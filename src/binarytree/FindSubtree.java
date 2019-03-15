package binarytree;

public class FindSubtree {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    private TreeNode subTree;
    private int subTreeSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subTree;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        if (sum <= subTreeSum) {
            subTreeSum = sum;
            subTree = root;
        }
        return sum;
    }
}
