package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class StackNode {
    private Node top;

    public void push(Integer data) {
        Node newNode = new Node(data);
        if (top != null) {
            newNode.setNext(top);
        }
        top = newNode;
    }

    public Node pop() {
        Node retNode = null;
        if(top != null) {
            retNode = top;
            top = top.getNext();
        }
        return retNode;
    }

    public Node peek() {
        return top;
    }

    public void print() {
        System.out.println("Stack: ");
        Node current = top;
        while (current != null) {
            System.out.print(current.getData() + "==>");
            current = current.getNext();
        }
        System.out.println("NULL");
    }
}
