package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */

public class Node {
    private Integer data;
    private Node pNext;

    public Node(final Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public Node getNext() {
        return pNext;
    }

    public void setNext(final Node pNext) {
        this.pNext = pNext;
    }
}
