package com.leetcode.challenges;

import com.datastructure.nodedemo.TreeNode;


/**
 * https://leetcode.com/problems/balanced-binary-tree/submissions/
 *
 * @author sanray on 11/24/2021
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int[] h = new int[2];
        int[] height = getHeight(root, h);
        if (Math.abs(height[0] - height[1]) <= 1) {
            return true;
        }
        return false;

    }

    public static int[] getHeight(TreeNode root, int[] height) {
        if (root == null) {
            return height;
        }

        int left = height[0];
        int right = height[1];
        if (root.left != null) {
            left = height[0] + getHeight(root.left, height)[0];
        }
        if (root.right != null) {
            right = height[1] + getHeight(root.right, height)[1];
        }

        return new int[] { left + 1, right +1};

    }
}
