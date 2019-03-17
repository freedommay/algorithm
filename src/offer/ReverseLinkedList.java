package offer;

import java.util.Stack;

public class ReverseLinkedList {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        Stack<Integer> st = new Stack<>();
        while (head != null) {
            st.push(head.val);
            head = head.next;
        }
        ListNode front = head = new ListNode(st.pop());
        while (!st.empty()) {
            front.next = new ListNode(st.pop());
            front = front.next;
        }
        front.next = null;
        return head;
    }

    public ListNode reverse2(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }
}
