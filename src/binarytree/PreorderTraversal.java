package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class PreorderTraversal {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    // 遍历方法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
    }

    // 分治方法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> left = preorderTraversal2(root.left);
        List<Integer> right = preorderTraversal2(root.right);
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    // 非递归
    public List<Integer> preorderTraversal3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
