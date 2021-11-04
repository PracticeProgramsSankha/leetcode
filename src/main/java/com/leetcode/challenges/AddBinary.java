package com.leetcode.challenges;

/**
 * @author sanray on 11/1/2021
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));

    }
    public static String addBinary(String a, String b) {

        int l1 = a.length() - 1;
        int l2 = b.length() - 1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (l1 >=0 || l2 >= 0) {
            int sum = carry;
            if(l1 >= 0 ) {
                sum += a.charAt(l1--) - '0';
            }
            if(l2 >= 0) {
                sum += b.charAt(l2--) - '0';
            }

            carry = sum > 1 ? 1 : 0;
            result.append(sum%2);
        }

        if(carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();

    }
}
