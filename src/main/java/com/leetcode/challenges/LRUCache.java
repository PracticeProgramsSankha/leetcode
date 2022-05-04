package com.leetcode.challenges;

import java.util.Hashtable;


/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author sanray on 3/10/2022
 *
 * Maintain a doubly linked list and hashmap
 * Every new read or write is done at head of list,
 * removal - check hashmap first and if exists get node from map and remvoe from list
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache sol = new LRUCache(2);

        /**
         * ["LRUCache", "put", "put",   "get", "put", "get", "put", "get", "get", "get"]
         * [[2],         [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
         */
        sol.put(1, 1);
        sol.put(2, 2);
        System.out.println("expected 1: got " + sol.get(1));
        sol.put(3, 3);
        System.out.println("expected 2: got " + sol.get(2));
        sol.put(4, 4);
        System.out.println("expected -1: got " + sol.get(1));
        System.out.println("expected 3: got " + sol.get(3));
        System.out.println("expected 4: got " + sol.get(4));
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
            this.prev = null;
            this.next = null;
        }
    }

    Hashtable<Integer, Node> lru;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.lru = new Hashtable<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        // if not exists return -1
        if (!lru.containsKey(key)) {
            return -1;
        }

        // if exists from  its current position and insert to beg
        Node existingNode = lru.get(key);
        Node prevNode = existingNode.prev;
        Node nextNode = existingNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        // inset to beg
        existingNode.next = head.next;
        existingNode.prev = head;
        head.next = existingNode;

        return existingNode.value;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (!lru.containsKey(key)) {

            if (lru.isEmpty()) {
                newNode.prev = head;
                newNode.next = tail;
                head.next = newNode;
                tail.prev = newNode;
            } else {
                // Some Node Exists
                // 1. if capacity is full, delete last
                if (lru.size() == capacity) {
                    Node lastNode = tail.prev;
                    lastNode.prev.next = tail;
                    tail.prev = lastNode.prev;
                    lru.remove(lastNode.key);
                }
                Node firstNode = head.next;
                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;

            }

        } else {
            Node existingNode = lru.get(key);
            existingNode.prev.next = existingNode.next;
            existingNode.next.prev = existingNode.prev;
            lru.remove(key);

            // Insert new node at beg
            Node firstNode = head.next;
            newNode.prev = head;
            newNode.next = firstNode;
            head.next = newNode;
            firstNode.prev = newNode;

        }

        lru.put(key, newNode);

    }

 /*   public void put(int key, int value) {

        // if the key is already present, delete it from list and insert it in beg
        if (lru.containsKey(value))  {
            Node existingNode = lru.get(key);

            // delete it
            Node prevNode = existingNode.prev;
            Node nextNode = existingNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            lru.remove(key);
        } else {
            // check if size is full, delete from end
            if (lru.size() == capacity) {
                Node last = tail.prev;
                last.prev.next = tail;
                tail.prev = last.prev;
                lru.remove(last.key);

            }
            // inset new node to beg
            Node newNode = new Node(key, value);
            newNode.next = head.next;
            newNode.prev = head;
            head.next = newNode;
            if(lru.isEmpty()) {
                head.next = newNode;
                newNode.prev = head;
                tail.prev = newNode;
                newNode.next = tail;
            } else {
                newNode.next = head.next;
                head.next.prev = newNode;

            }
            lru.put(key, newNode);
        }
    }*/
}
