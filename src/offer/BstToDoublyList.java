package offer;

public class BstToDoublyList {

    private DoublyListNode head = null;
    private DoublyListNode tail = null;

    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        visit(root);
        return head;
    }

    private void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root.left);
        convert(root);
        visit(root.right);
    }

    private void convert(TreeNode root) {
        DoublyListNode node = new DoublyListNode(root.val);
        node.prev = tail;
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }
}
