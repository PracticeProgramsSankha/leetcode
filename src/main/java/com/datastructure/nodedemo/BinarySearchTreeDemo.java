package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(25);
        bst.insert(22);
        bst.insert(50);
        bst.insert(65);
        bst.insert(70);
        bst.traversePreOrder();
        bst.traverseInOrder();
        bst.traversePostOrder();
        bst.printHeight();


        bst.deleteNode(65);
        bst.traversePreOrder();
        bst.traverseInOrder();
        bst.traversePostOrder();

        bst.printHeight();



    }
}
