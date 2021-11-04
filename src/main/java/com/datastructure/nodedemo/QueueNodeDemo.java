package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class QueueNodeDemo {
    public static void main(String[] args) {
        QueueNode queue = new QueueNode();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.print();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();

        queue.enqueue(99);
        queue.enqueue(98);
        queue.print();
    }
}
