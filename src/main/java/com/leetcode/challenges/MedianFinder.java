package com.leetcode.challenges;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class MedianFinder {
    public static void main(String[] args) {
        test1();

    }

    private static void test1() {
        MedianFinder sol = new MedianFinder();
        sol.addNum(1);
        sol.addNum(2);
        System.out.println(sol.findMedian());
        sol.addNum(3);
        System.out.println(sol.findMedian());
    }

    Queue<Integer> leftQueue; // MaxHeap
    Queue<Integer> rightQueue; // MinHeap

    public MedianFinder() {
        leftQueue = new PriorityQueue<>(Collections.reverseOrder());
        rightQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftQueue.isEmpty() || num <= leftQueue.peek()) {
            leftQueue.offer(num);
        } else {
            rightQueue.offer(num);
        }

        // Balance the heap
        if (leftQueue.size() < rightQueue.size()) {
            leftQueue.offer(rightQueue.poll());
        } else if (leftQueue.size() - rightQueue.size() > 1) {
            rightQueue.offer(leftQueue.poll());
        }
    }

    public double findMedian() {
        if (leftQueue.size() == rightQueue.size()) {
            return (leftQueue.peek() + rightQueue.peek()) / 2.0f;
        }
        return leftQueue.peek();
    }
}
