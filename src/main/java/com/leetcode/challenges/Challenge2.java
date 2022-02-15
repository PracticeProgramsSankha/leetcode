package com.leetcode.challenges;

import java.math.BigInteger;


/**
 * @author sanray on 10/20/2021
 */

public class Challenge2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum1 = getSum(l1);
        BigInteger sum2 = getSum(l2);
        BigInteger total = sum1.add(sum2);

        if (total == BigInteger.ZERO) {
            return new ListNode(0, null);
        }

        ListNode retNode = new ListNode();
        ListNode result = retNode;
        while (total != BigInteger.ZERO) {
            int div = total.mod(BigInteger.TEN).intValue();
            ListNode temp = new ListNode(div, null);
            retNode.next = temp;
            retNode = retNode.next;
            total = total.divide(BigInteger.TEN);
        }

        return result.next;

    }

    private static BigInteger getSum(ListNode node) {
        BigInteger sum = BigInteger.ZERO;
        int power = 0;
        while (node != null) {
            sum = sum.add(BigInteger.valueOf(node.val).multiply(getMultiplierOf10(power)));
            node = node.next;
            power++;
        }
        return sum;
    }

    private static BigInteger getMultiplierOf10(int power) {
        BigInteger mul = BigInteger.ONE;
        for (int i = 0; i < power; i++) {
            mul = mul.multiply(BigInteger.TEN);
        }
        return mul;
    }

    public static void main(String[] args) {

        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

/*        ListNode l1 = ListNode.deserialize("[0]");
        ListNode l2 = ListNode.deserialize("[0]");*/

/*        ListNode l1 = ListNode.deserialize("[9]");
        ListNode l2 = ListNode.deserialize("[1,9,9,9,9,9,9,9,9,9]");*/

/*        ListNode l1 = ListNode.deserialize("[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");*/

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val + " ");
            result = result.next;
        }

    }
}


