/**
 * Created by thd on 2017/2/28.
 */

public class Findnode {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) return null;
        int i = 0, j = 0;
        ListNode find = head;
        ListNode node = head;
        for(; i < k-1; i++){
            if(find.next != null)
                find = find.next;
            else return null;
        }
        while(find.next != null){
            find = find.next;
            node = node.next;
        }
        return node;
    }
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next =listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        Findnode fn = new Findnode();
        System.out.println(fn.FindKthToTail(listNode1,4).val);
    }
}
