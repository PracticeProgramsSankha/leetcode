package com.leetcode.challenges;

/**
 * @author sanray on 11/1/2021
 */
public class OddEvenList {

    public static void main(String[] args) {

        ListNode head = null;
        int num = 1;
        for (int i = num; i > 0; i--) {
            head = new ListNode(i, head);
        }

        printList(head);

        ListNode ret = oddEvenList(head);

        printList(ret);
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

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        // Find the mid
        ListNode current = head;
        ListNode evenHead = null, even = null;
        ListNode oddHead = null, odd = null;
        int counter = 0;
        while (current != null) {
            if (counter % 2 != 0) {
                if (evenHead == null) {
                    evenHead = current;
                    even = current;
                } else {
                    even.next = current;
                    even = even.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = current;
                    odd = current;
                } else {
                    odd.next = current;
                    odd = odd.next;
                }
            }
            current = current.next;
            counter++;
        }

        if(evenHead != null) {
            even.next = null;
            odd.next = evenHead;
        } else {
            odd.next = null;
        }

        return oddHead;
    }

}
