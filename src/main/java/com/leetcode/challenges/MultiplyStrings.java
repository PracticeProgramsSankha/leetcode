package com.leetcode.challenges;

import java.math.BigInteger;
import java.util.Stack;


/**
 * @author sanray on 11/7/2021
 */
public class MultiplyStrings {
    public static void main(String[] args) {

        System.out.println(multiply("100", "100"));
    }

    public static String multiply(String num1, String num2) {
        if (isZero(num1)) {
            return 0 + "";
        }
        if (isZero(num2)) {
            return 0 + "";
        }

        BigInteger bigNum1 = new BigInteger(num1);
        BigInteger bigNum2 = new BigInteger(num2);
        return bigNum1.multiply(bigNum2).toString();
    }

    public static void shiftleft(final char[] result) {
        for(int i = result.length -1; i > 0; i--) {
            result[i-1] = result[i];
        }
        result[result.length -1] = 0;
    }

    public static String multiply1(String num1, String num2) {
        if (isZero(num1)) {
            return 0 + "";
        }
        if (isZero(num2)) {
            return 0 + "";
        }

        int totalLength = num1.length() + num2.length();
        char[] result = new char[totalLength];
        for (int i = 0; i < totalLength; i++) {
            result[i] = 0;
        }

        for (int i = num2.length() - 1; i >= 0; i--) {
            int mul = num2.charAt(i) - '0';
            if (mul == 0) {
                // Shiftleft
                shiftleft(result);
                continue;
            }
            multiply(result, num1, mul, i);
        }

        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0; i < totalLength; i++) {
            result[i] += '0';
        }
        return result.toString();
    }


    public static void multiply(char[] resultStr, String num1, int mul, int index) {
        Stack<Character> stack = new Stack<>();
        int carry = 0;
        int result = 1;
        int resultLen = resultStr.length;
        int j = index;
        for (int i = num1.length() - 1; i >= 0; i--) {
            result = num1.charAt(i) - '0' * mul;
            int prev = j < resultLen ? resultStr[resultLen - 1 - j] - '0' : 0;
            resultStr[resultLen - 1 - j] = ((char) ('0' + prev + carry + result % 10));
            carry = result / 10;
            j++;
        }

        if (carry > 0) {
            int r = resultStr[resultLen - 1 - j] + carry;
            resultStr[resultLen - 1 - j] = ((char) (r % 10));
            if (r / 10 != 0) {
                j++;
                resultStr[resultLen - 1 - j] = ((char) (r / 10));
            }
        }
    }

    public static boolean isZero(String str) {
        return str.length() == 1 && (str.charAt(0) - '0' == 0);
    }
}
