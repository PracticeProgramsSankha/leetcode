package com.leetcode.challenges;

/**
 * @author sanray on 11/1/2021
 */
public class ReorderList {

    public static void main(String[] args) {

        ListNode head = null;
        int num = 4;
        for (int i = num; i > 0; i--) {
            head = new ListNode(i, head);
        }

        printList(head);

        reorderList(head);

        printList(head);
    }

    private static void printList(final ListNode head) {
        ListNode temp = head;
        System.out.print("\nList: ");
        while (temp != null) {
            System.out.print(temp.val + " ==> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // Find the mid
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse from mid
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Merge list
        ListNode n1 = head;
        ListNode n2 = prev;
        while (n2.next != null) {
            temp = n1.next;
            n1.next = n2;
            n1 = temp;

            temp = n2.next;
            n2.next = n1;
            n1 = temp;
        }
    }

}
