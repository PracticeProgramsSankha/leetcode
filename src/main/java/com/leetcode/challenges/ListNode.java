package com.leetcode.challenges;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    public void print() {
        ListNode temp = this;
        while(temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static ListNode deserialize(String val) {

        List<Integer> nums =
                Stream.of(val.split(""))
                        .filter(s -> isNumeric(s))
                        .map(Integer::parseInt).collect(Collectors.toList());
        ListNode head = new ListNode();
        ListNode temp = head;
        for (Integer in : nums) {
            temp.next = new ListNode(in, null);
            temp = temp.next;
        }

        return head.next;
    }

    static boolean isNumeric(String s) {
        try {
            Integer v = Integer.parseInt(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}

