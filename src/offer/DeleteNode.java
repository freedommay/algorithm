package offer;

public class DeleteNode {
    /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        if (node.next == null) node = null;
        else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
