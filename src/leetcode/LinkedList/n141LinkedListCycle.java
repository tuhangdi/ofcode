package leetcode.LinkedList;

/**
 * Created by thd on 2017/7/25
 * Given a linked list, determine if it has a cycle in it.
 */
public class n141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
