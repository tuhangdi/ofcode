package leetcode.Array;

import java.util.Hashtable;

/**
 * Created by thd on 2017/8/23
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 设计和实现最近使用（LRU）缓存的数据结构。 它应该支持以下操作：get和put。
 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 get（key） - 如果键存在于缓存中，则获取键的值（将始终为正），否则返回-1。
 put（key，value） - 如果键不存在，则设置或插入该值。 当缓存达到其容量时，它应该在插入新项目之前使最近使用的项目无效。
 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 /* capacity  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4



 Hashtable + 双链表
 用一个哈希表来跟踪双链表中的键及其值。关于双链表的一个有趣的属性是节点可以删除自己，而无需其他引用。此外，从头部或尾部添加和删除节点是恒定时间。

 我实现的双重链表的一个特殊之处在于创建一个伪头和伪尾来标记边界，这样我们就不需要在更新过程中检查NULL节点。这使得代码更加简洁和干净，性能更好。

 */

public class n146LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * Always add the new node right after head;
     *
     * */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list
     *
     * */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head
     * */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * Pop the current tail
     * */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public n146LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; //shoud raise exception here
        }

        //move the accessed node to the head
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                //pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            //update the value
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
