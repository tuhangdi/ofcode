package leetcode.LinkedList;

import java.util.LinkedList;

/**
 * Created by thd on 2017/8/15
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 给定链表，从列表的末尾删除第n个节点并返回其头。
 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 可以使用指针完成单程解决方案。 移动一个快速指针 - > n + 1前进，保持两个指针之间的n间隙，然后以相同的速度移动。
 最后，当快速指针到达结束时，慢指针将是n + 1个位置 - 只是正确的位置才能跳过下一个节点。

 */
public class n19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = slow.next.next;
        return start.next;
    }
}
