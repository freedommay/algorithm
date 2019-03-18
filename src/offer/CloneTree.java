package offer;

public class CloneTree {
    /**
     * @param root: The root of binary tree
     * @return: root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(0);
        helper(root, newRoot);
        return newRoot;
    }

    private void helper(TreeNode root, TreeNode newRoot) {
        newRoot.val = root.val;
        newRoot.left = root.left;
        newRoot.right = root.right;
        if (root.left != null) {
            helper(root.left, newRoot.left);
        }
        if (root.right != null) {
            helper(root.right, newRoot.right);
        }
    }
}
