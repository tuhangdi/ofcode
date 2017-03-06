/**
 * Created by thd on 2017/3/6.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Complexlistcopy {
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode pNode = pHead;
        if (pHead == null) return null;
        while(pNode != null) {//复制原始链表的任意结点N并创建新结点N'，再把N'链接到N的后面
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }

        pNode = pHead;
        while (pNode != null){//如果原始链表上的结点N的random指向S，则它对应的复制结点N'的random指向S的下一个结点S'。
            RandomListNode pCloned = new RandomListNode(pNode.label);
            if(pNode.random != null){
                pCloned.random = pNode.next.random;
            }
            pNode = pCloned.next;
        }

        pNode = pHead;
        RandomListNode pClonedHead = pNode.next;
        RandomListNode pClonedNode = pNode.next;
        pNode.next = pClonedNode.next;
        pNode = pNode.next;
        while(pNode != null){//把第二步得到的链表拆分成两个链表，奇数位置上的结点组成原始链表，偶数位置的结点组成复制出来的链表。
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

}
