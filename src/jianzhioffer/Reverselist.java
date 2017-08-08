package jianzhioffer;

/**
 * Created by thd on 2017/3/3.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Reverselist {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(7);
        listNode1.next =listNode2;
        listNode2.next = listNode3;
        Reverselist rl = new Reverselist();
        ListNode rv = rl.ReverseList(listNode1);
        while(rv != null){
            System.out.println(rv.val);
            rv =  rv.next;
        }
    }
}
