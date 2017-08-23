package leetcode.LinkedList;

/**
 * Created by thd on 2017/8/23
 * Sort a linked list in O(n log n) time using constant space complexity.
 使用恒定空间复杂度在O（n log n）时间内对链表进行排序。
 *
 * nlogn->归并
 */
public class n148SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }
    public ListNode merge (ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;

        return l.next;
    }
}
