package com.leetcode.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


/**
 * @author sanray on 12/19/2021
 */
public class InsertionSortList {
    public static void main(String[] args) {

        test1();
        test2();
    }

    private static void test1() {
        List<Integer> list = Arrays.asList(4, 2, 1, 3);
        ListNode node = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode temp = new ListNode(list.get(i), node);
            node = temp;
        }

        print(node);
        ListNode ans = insertionSortList(node);
        print(ans);

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        int sum = 0;
        for(Integer s : stack) {
            sum+=s;
        }
        System.out.println(sum);
    }

    private static void test2() {
        List<Integer> list = Arrays.asList(-1, 0, 3, 4, 5);
        ListNode node = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode temp = new ListNode(list.get(i), node);
            node = temp;
        }

        print(node);
        ListNode ans = insertionSortList(node);
        print(ans);

    }

    public static void print(ListNode head) {
        System.out.print("Queue: ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "==>");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode pos = getPosition(dummy, head.val);
            // Insert at position
            ListNode curr = head;
            head = head.next;
            curr.next = pos.next;
            pos.next = curr;
        }

        return dummy.next;

    }

    public static ListNode getPosition(ListNode dummy, int val) {
        // Dummy is always sorted
        ListNode curr = dummy;
        ListNode next = curr.next;
        while (next != null && next.val < val) {
            curr = next;
            next = next.next;
        }
        return curr;
    }
}
