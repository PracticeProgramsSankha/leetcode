package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class QueueNode {
    private Node head;
    private Node tail;

    public void enqueue(Integer data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public Node dequeue() {
        if (head == null) {
            return null;
        }

        Node retNode = head;
        head = head.getNext();
        return retNode;
    }

    public void print() {
        System.out.print("Queue: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + "==>");
            current = current.getNext();
        }
        System.out.println("NULL");
    }
}
