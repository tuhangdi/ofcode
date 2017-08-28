package leetcode.LinkedList;

import java.util.List;

/**
 * Created by thd on 2017/8/28
 *
 * Reverse a singly linked list.
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 */
public class n206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {//iterative
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }



    public ListNode reverseListRec(ListNode head) {//recursive
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt (ListNode head, ListNode newHead){
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}

