package offer2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by thd on 2017/5/24.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Sol5 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> pr = new ArrayList<Integer>();
        if (listNode == null) return pr;
        Stack<Integer> s = new Stack<>();
        while (listNode != null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }
        while (!s.isEmpty()) {
            pr.add(s.pop());
        }
        return pr;
    }
}
