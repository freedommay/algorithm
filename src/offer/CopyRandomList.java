package offer;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode cur = head;
        RandomListNode copy = newHead;
        map.put(cur, copy);
        while (cur.next != null) {
            cur = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            copy.next = node;
            copy = node;
            map.put(cur, copy);
        }
        copy.next = null;
        while (head != null) {
            if (head.random != null) {
                map.get(head).random = map.get(head.random);
            }
            head = head.next;
        }
        return newHead;
    }
}
