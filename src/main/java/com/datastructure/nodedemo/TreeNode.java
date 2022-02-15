package com.datastructure.nodedemo;

/**
 * @author sanray on 10/26/2021
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public Integer getVal() {
        return val;
    }

    public void setLeft(final TreeNode left) {
        this.left = left;
    }

    public void setRight(final TreeNode right) {
        this.right = right;
    }

    public TreeNode findNode(Integer data) {
        if (data < this.val && left != null) {
            return left.findNode(data);
        } else if (right != null) {
            return right.findNode(data);
        }
        return null;
    }

    public void insert(Integer data) {
        if (data >= this.val) {
            if (right == null) {
                right = new TreeNode(data);
            } else {
                right.insert(data);
            }
        } else {
            if (left == null) {
                left = new TreeNode(data);

            } else {
                left.insert(data);
            }
        }
    }

    public void traversePreOrder() {
        System.out.print(this.getVal() + "==>");
        if (left != null) {
            left.traversePreOrder();
        }
        if (right != null) {
            right.traversePreOrder();
        }
    }

    public void traverseInOrder() {
        if (left != null) {
            left.traverseInOrder();
        }
        System.out.print(this.getVal() + "==>");
        if (right != null) {
            right.traverseInOrder();
        }
    }

    public void traversePostOrder() {
        if (left != null) {
            left.traversePostOrder();
        }
        if (right != null) {
            right.traversePostOrder();
        }
        System.out.print(this.getVal() + "==>");
    }

    public boolean isLeaf() {
        return right == null && left == null;
    }

    public TreeNode getSuccessor() {
        TreeNode parent = this;
        TreeNode successor = this;
        TreeNode current = this;
        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != right) {
            parent.setLeft(successor.getLeft());
            successor.setRight(right);
        }
        return successor;
    }

    public int getHeight() {
        if (isLeaf()) {
            return 1;
        }
        int leftHeight = left != null ? left.getHeight() : 0;
        int rightHeight = right != null ? right.getHeight() : 0;
        return leftHeight > rightHeight ? (leftHeight + 1) : (rightHeight + 1);
    }
}
