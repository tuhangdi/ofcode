package offer2;

/**
 * Created by thd on 2017/6/1.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Sol15 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode knode = head;
        ListNode findnode = head;
        for (int i = 0; i < k - 1; i++) {
            if (knode.next != null)
                knode = knode.next;
            else return null;
        }
        while (knode.next != null) {
            findnode = findnode.next;
            knode = knode.next;
        }
        return findnode;
    }
}
