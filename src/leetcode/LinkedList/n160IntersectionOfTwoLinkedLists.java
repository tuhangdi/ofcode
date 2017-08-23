package leetcode.LinkedList;

/**
 * Created by thd on 2017/8/23
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 编写程序以查找两个单链表的交点开始的节点。

 For example, the following two linked lists:

 A:          a1 → a2
                     ↘
                     c1 → c2 → c3
                     ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 如果两个链表都没有交集，返回null。
 链表在函数返回后必须保留其原始结构。
 您可以假定整个链接结构中没有任何循环。
 您的代码应在O（n）时间内运行，并且仅使用O（1）内存。


 */
public class n160IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }

    public int len(ListNode head) {
        int len = 0;
        if (head == null) return len;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
