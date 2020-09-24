package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author: huhao
 * @time: 2020/9/24 10:39
 * @desc: https://leetcode.com/problems/find-median-from-data-stream/
 */
public class H295_FindMedianfromDataStream {

    /**
     * max heap to store the larger half of input numbers
     */
    PriorityQueue<Integer> maxHeap;
    /**
     * min heap to store the smaller half of input numbers
     */
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public H295_FindMedianfromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    /**
     * addNum strategy: new number will be inserted into max heap, and then (after heapify) move the root of max heap
     * to the min heap. Always keep balance (maxHeap.size() >= minHeap.size()) of the two heaps after insertion step.
     * @param num
     */
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // keep balance of two heaps
        if (maxHeap.size()< minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.poll();
        }else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
