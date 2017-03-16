/**
 * Created by thd on 2017/3/16.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Findcode37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null) return  null;
        int length1 = ListLength(pHead1);
        int length2 = ListLength(pHead2);
        ListNode listLong = pHead1;
        ListNode listShort = pHead2;
        int diff = length1 - length2;
        if(length1 < length2){
            listLong = pHead2;
            listShort = pHead1;
            diff = length2 - length1;
        }
        for (int i = 0; i < diff; i++){
            listLong = listLong.next;
        }
        while (listLong != null && listShort != null && listLong != listShort){
            listLong = listLong.next;
            listShort = listShort.next;
        }
        return listLong;
    }
    public int ListLength(ListNode pHead){
        int count = 0;
        ListNode pNode = pHead;
        while(pNode != null){
            count ++;
            pNode = pNode.next;
        }
        return count;
    }
}
