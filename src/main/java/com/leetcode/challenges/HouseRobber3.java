package com.leetcode.challenges;

import com.datastructure.nodedemo.BinarySearchTree;
import com.datastructure.nodedemo.TreeNode;


/**
 * @author sanray on 10/31/2021
 */
public class HouseRobber3 {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(30);
        tree.insert(25);
        tree.insert(22);
        tree.insert(50);
        tree.insert(65);
        tree.insert(70);
        tree.insert(100);

        System.out.println(rob(tree.getRoot()));

    }

    public static int rob(TreeNode root) {
        int []result = getMaxValueWithRoot(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] getMaxValueWithRoot(final TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = getMaxValueWithRoot(root.getLeft());
        int[] right = getMaxValueWithRoot(root.getRight());

        int withRoot = root.getData() + left[1] + right[1];
        int withoutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] {withRoot, withoutRoot};
    }

}
