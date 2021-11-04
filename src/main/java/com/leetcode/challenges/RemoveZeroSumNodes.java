package com.leetcode.challenges;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


/**
 * @author sanray on 11/1/2021
 */
public class RemoveZeroSumNodes {

    public static void main(String[] args) {
        test1(new int[] { 1, -1 });
        test1(new int[] { 0, 0 });
        test1(new int[] { 1, 2, 3, -3, -2 });
        test1(new int[] { 2, 0 });

        test1(new int[] { 1, 2, 3, -3, 4 });

        test1(new int[] { 1, 2, -3, 3, 1 });

    }

    public static void test1(int[] nums) {
        System.out.println("Test start=========");
        ListNode head = null;

        for (int i = nums.length - 1; i >= 0; i--) {
            head = new ListNode(nums[i], head);
        }

        printList(head);

        ListNode ret = removeZeroSum(head);

        printList(ret);
        System.out.println("Test end=========");

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

    public static ListNode removeZeroSum(ListNode head) {
        if (head == null) {
            return null;
        }

        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        map.put(0, dummy);

        int accumulatedSum = 0;
        while (head != null) {
            accumulatedSum += head.val;
            if (map.containsKey(accumulatedSum)) {
                // Clear the map
                int tempSum = accumulatedSum;
                ListNode nodeToRemove = map.get(accumulatedSum).next;
                while (nodeToRemove != head) {
                    tempSum += nodeToRemove.val;
                    map.remove(tempSum);
                    nodeToRemove = nodeToRemove.next;
                }
                map.get(accumulatedSum).next = head.next;
            } else {
                map.put(accumulatedSum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }

}
