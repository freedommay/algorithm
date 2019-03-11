package list;

/**
 * Definition for ListNode
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class ReverseKGroup {
    /**
     * @param head: a ListNode
     * @param k:    An integer
     * @return: a ListNode
     */
    // dummy -> head -> n1 -> n2 -> ... -> nk -> nk+1 -> ...
    // dummy -> nk -> nk-1 -> ... n2 -> n1 -> ...
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        dummy = head;
        while (true) {
            head = reverseNextK(head, k);
            if (head == null) {
                break;
            }
        }
        return dummy.next;
    }

    private ListNode reverseNextK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        ListNode n1 = head.next;
        ListNode nkplus = nk.next;
        ListNode prev = null;
        ListNode cur = n1;
        while (cur != nkplus) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head.next = nk;
        n1.next = nkplus;
        return n1;
    }
}
