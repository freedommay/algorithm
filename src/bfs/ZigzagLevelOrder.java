package bfs;

import java.util.*;

public class ZigzagLevelOrder {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        int flag = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null ) queue.offer(node.left);
                if (node.right != null ) queue.offer(node.right);
            }
            if (flag == 1) {
                Collections.reverse(level);
            }
            flag = 1 - flag;
            result.add(level);
        }
        return result;
    }
}
