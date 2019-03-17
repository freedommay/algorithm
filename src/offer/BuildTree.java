package offer;

public class BuildTree {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param preorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return treeNode;
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = find(inorder, preorder[preStart]);
        root.left = helper(preorder, preStart + 1, preStart + pos - inStart,
                inorder, inStart, pos - 1);
        root.right = helper(preorder, preStart + pos - inStart + 1, preEnd,
                inorder, pos + 1, inEnd);
        return root;
    }

    private int find(int[] order, int num) {
        int len = order.length;
        for (int i = 0; i < len; i++) {
            if (order[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
