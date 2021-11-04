package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }

    public TreeNode findNode(Integer data) {
        if (root == null) {
            return null;
        }

        return root.findNode(data);
    }

    public void insert(Integer data) {
        System.out.println("inserting node: " + data);
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public TreeNode deleteNode(Integer data) {
        System.out.println("deleting node: " + data);
        if (root == null) {
            return null;
        }

        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftNode = true;
        // find the node to be deleted
        while (current != null && data != current.getData()) {
            parent = current;
            if (data < current.getData()) {
                current = current.getLeft();
                isLeftNode = true;
            } else {
                current = current.getRight();
                isLeftNode = false;
            }
        }

        // no data found
        if (current == null) {
            return null;
        }

        // 1. Node to be deleted is Leaf
        if (current.isLeaf()) {
            if (current == parent) {
                parent = null;
            } else {
                if (isLeftNode) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
        } // 2a. Node to be deleted has one child
        else if (current.getLeft() == null) { // current have right child
            if (current == root) {
                root = current.getRight();
            } else if (isLeftNode) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftNode) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else {
            // 3. Node to be deleted has two child. complicated, since we need to get a successor
            TreeNode successor = current.getSuccessor();
            if (root == current) {
                root = successor;
            } else if (isLeftNode) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }

        return current;
    }

    public void traversePreOrder() {
        if (root == null) {
            return;
        }
        System.out.print("\nPreOrderTraversal: ");
        root.traversePreOrder();
    }

    public void traverseInOrder() {
        if (root == null) {
            return;
        }
        System.out.print("\nInOrderTraversal: ");
        root.traverseInOrder();
    }

    public void traversePostOrder() {
        if (root == null) {
            return;
        }
        System.out.print("\nPostOrderTraversal: ");
        root.traversePostOrder();
    }

    public void printHeight() {
        System.out.println("\nHeight of tree: " + root.getHeight());
    }
}
