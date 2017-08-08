package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by thd on 2017/2/22.
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Arrayprint {
    //使用栈的后进先出
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> nodes = new Stack<>();
        while(listNode != null){
            nodes.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!nodes.isEmpty()){
            list.add(nodes.pop());
        }
        return list;
    }
    //所有用栈的题，都可以使用递归
    public ArrayList<Integer> printListFromTailToHeadRecursion(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        Recursion(list, listNode);
        return list;
    }
    public  void Recursion(ArrayList<Integer> list, ListNode listNode){
        if (listNode != null){
            if (listNode != null){
                Recursion(list, listNode.next);
            }
            list.add(listNode.val);
        }
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(7);
        listNode1.next =listNode2;
        listNode2.next = listNode3;

        Arrayprint al = new Arrayprint();
        ArrayList<Integer> listt;
        ArrayList<Integer> listr;
        listt = al.printListFromTailToHead(listNode1);
        listr = al.printListFromTailToHeadRecursion(listNode1);

        for(Integer i : listt){
            System.out.println(i);
        }
        for(Integer i : listr){
            System.out.println(i);
        }
    }
}

