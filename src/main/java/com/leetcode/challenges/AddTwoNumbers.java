package com.leetcode.challenges;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * @author sanray on 2/16/2022
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

        ListNode l1 = ListNode.createListNode(new int[] { 2, 4, 3 });
        ListNode l2 = ListNode.createListNode(new int[] { 5, 6, 4 });
        l1.print();
        l2.print();
        ListNode result = addTwoNumbers(l1, l2);
        result.print();;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum /10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }

}


