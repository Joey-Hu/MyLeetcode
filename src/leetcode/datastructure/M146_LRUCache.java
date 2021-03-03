package leetcode.datastructure;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author: huhao
 * @time: 2020/9/21 14:56
 * @desc: https://leetcode.com/problems/lru-cache/
 * 本题出的是一种缓存淘汰策略，LRU 缓存淘汰算法就是一种常用策略。LRU 的全称是 Least Recently Used，
 * 也就是说我们认为最近使用过的数据应该是是「有用的」，很久都没用过的数据应该是无用的，内存满了就优先删那些很久没用过的数据。
 *
 * LRU 缓存算法的核心数据结构就是哈希链表，双向链表和哈希表的结合体。
 */
public class M146_LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    /**
     * 把结点添加在head的后面
     * @param node
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * 从链表中移除一个结点
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * 将中间的某个结点移动到头部
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * 弹出当前的尾部结点
     * @return
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public M146_LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode res = cache.get(key);
        if (res == null) {
            return -1;
        }

        // 如果获取了该节点，就将该节点放到head后面（表示最近使用过），保持tail表示的是最久没有使用过的
        this.moveToHead(res);

        return res.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            // 这里的 put 方法是 HashMap 自带的
            this.cache.put(key, newNode);
            this.addNode(newNode);

            if (cache.size() > capacity) {
                DLinkedNode tail = this.popTail();
                // 别忘了删除cache中的结点数据
                this.cache.remove(tail.key);
            }
        } else {
            // 更新节点
            node.value = value;
            this.moveToHead(node);
        }
    }
}
