package com.datastructure.nodedemo;

/**
 * @author sanray on 11/1/2021
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (Integer in : nums) {
            temp.next = new ListNode(in, null);
            temp = temp.next;
        }

        return head.next;
    }

}

