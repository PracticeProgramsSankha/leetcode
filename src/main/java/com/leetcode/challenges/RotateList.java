package com.leetcode.challenges;

/**
 * @author sanray on 11/25/2021
 */
public class RotateList {
    public static void main(String[] args) {

        ListNode node = null;
        for (int i = 2; i > 0; i--) {
            node = new ListNode(i, node);
        }

        rotateRight(node, 1);

        node = null;
        for (int i = 5; i > 0; i--) {
            node = new ListNode(i, node);
        }

        rotateRight(node, 2);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 0;
        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        current.next = head;

        while (k-- > 0) {
            current = head;
            head = head.next;
        }
        current.next = null;

        return head;
    }
}
