package offer;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDelete = dummy;
        while (n > 0) {
            head = head.next;
            n--;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}
