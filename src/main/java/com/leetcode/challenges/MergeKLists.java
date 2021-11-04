package com.leetcode.challenges;

/**
 * @author sanray on 10/31/2021
 */
public class MergeKLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length <= 1) {
            return lists[0];
        }

        return mergeLists(lists, 0, lists.length);

        /*

        ListNode returnNode = lists[0];
        for(int i = 1; i < lists.length; i++ ) {
            returnNode = mergeTwoLists(returnNode, lists[i]);
        }
        return returnNode;
        */

    }

    public ListNode mergeLists(ListNode[] lists, int start, int end) {

        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode merged1 = mergeLists(lists, start, mid);
            ListNode merged2 = mergeLists(lists, mid + 1, end);
            mergeTwoLists(merged1, merged2);
        }

        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode returnnode = new ListNode();
        ListNode node = returnnode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        while (l1 != null && l2 == null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null && l1 == null) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }

        return returnnode.next;
    }
}
