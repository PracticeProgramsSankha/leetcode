package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class StackNodeDemo {
    public static void main(String[] args) {
        StackNode stackNode = new StackNode();
        stackNode.push(10);
        stackNode.push(20);
        stackNode.push(30);
        stackNode.push(40);
        stackNode.push(50);

        stackNode.print();;

        stackNode.pop();
        stackNode.pop();
        stackNode.print();

        System.out.println(stackNode.peek().getData());

        stackNode.push(44);
        stackNode.push(55);
        stackNode.print();
    }
}
