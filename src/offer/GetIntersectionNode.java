package offer;

public class GetIntersectionNode {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0, lenB = 0;
        while (tempA != null) {
            tempA = tempA.next;
            lenA++;

        }
        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }
        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        while (headA.next != headB.next) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA.next;
    }
}
