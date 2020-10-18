package leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/9/21 15:35
 * @desc: https://leetcode.com/problems/lfu-cache/
 * 参考：https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
 *
 * 和LRU Cache经常出现在面试中
 */

public class LFUCache {

    final int capacity;
    int curSize;
    /**
     * for O(1)
     */
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;

    /**
     * @param capacity: total capacity of LFU Cache
     * @param curSize: current size of LFU cache
     * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
     * @param cache: a hashTable map that has key to Node mapping, which used for storing all nodes by their keys
     * @param frequencyMap: a hashTable map that has key to linked list mapping, which used for storing all
     *                    double linked list by their frequencies
     */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null) {
            return -1;
        }
        update(curNode);

        return curNode.val;
    }

    public void put(int key, int value, DLLNode minFreqNode1) {
        // coner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            update(curNode);
        }else {
            curSize ++;
            if (curSize > capacity) {
                // get minimum frequency list
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                // remove the oldest node when more than one node have equal minimum frequency
                DLLNode minFreqNode = minFreqList.popLast();
                cache.remove(minFreqNode.key);
                curSize--;
            }

            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }

    private void update(DLLNode curNode) {
        int frequency = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(frequency);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (frequency == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }

        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);

        curNode.frequency++;
    }

    class DLLNode {
        int key;
        int val;
        int frequency;
        DLLNode prev;
        DLLNode next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
        }
    }

    class DoubleLinkedList {
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加结点到head后，然后listsize自增1
         * @param curNode
         */
        public void addNode(DLLNode curNode) {
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        /**
         * 移除链表中间的某个结点
         * @param curNode
         */
        public void removeNode(DLLNode curNode) {
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

        /**
         * 返回链表尾节点
         * @return
         */
        public DLLNode popLast() {
            if (listSize > 0) {
                DLLNode tail = this.tail.prev;
                removeNode(tail);
                return tail;
            }
            return null;
        }
    }
}
