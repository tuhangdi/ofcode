/**
 * Created by thd on 2017/3/3.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Mergelist {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return  list1;
        ListNode merge;
        if(list1.val < list2.val){
            merge = list1;
            merge.next = Merge(list1.next, list2);
        }
        else{
            merge = list2;
            merge.next = Merge(list1, list2.next);
        }
        return merge;
    }
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(7);
        listNode1.next =listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(8);
        listNode4.next =listNode5;
        listNode5.next = listNode6;

        Mergelist ml = new Mergelist();
        ListNode merge = ml.Merge(listNode1, listNode4);
        while (merge != null){
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
