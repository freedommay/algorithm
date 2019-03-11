package list;

public class ReverseBetween {
    /**
     * @param head: ListNode head is the head of the linked list
     * @param m:    An integer
     * @param n:    An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode startMinus = head;
        ListNode start = head.next;
        ListNode end = start;
        ListNode endPlus = end.next;
        for (int i = m; i < n; i++) {
            ListNode temp = endPlus.next;
            endPlus.next = end;
            end = endPlus;
            endPlus = temp;
        }
        start.next = endPlus;
        startMinus.next = end;
        return dummy.next;
    }
}
