package com.datastructure;

import java.util.HashMap;


/**
 * @author sanray on 10/29/2021
 */
public class Palindrome {
    public static boolean isPalindromeNumber(Integer num) {
        int temp = num;
        int collector = 0;
        while (temp != 0) {
            collector = 10 * collector + (temp % 10);
            temp /= 10;
        }
        return collector == num;
    }

    public static boolean isPalindromeString(String str) {
        int length = str.length();
        int mid = length / 2;
        int counter = 0;
        while (counter < mid) {
            if (str.charAt(counter) != str.charAt(length - 1 - counter)) {
                break;
            }
            counter++;
        }
        if (counter == mid) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        testPalindromeNumber(101);
        testPalindromeNumber(1221);
        testPalindromeNumber(12321);
        testPalindromeNumber(12321);
        testPalindromeNumber(22321);
        testPalindromeNumber(22322);

        testPalindromeString("aa");
        testPalindromeString("aba");
        testPalindromeString("abc");
        testPalindromeString("aabbaa");
        testPalindromeString("acbca");
    }

    public static void testPalindromeNumber(Integer number) {
        System.out.println(String.format("Number %d is palindrome : %s", number,
                isPalindromeNumber(number) ? "TRUE" : "FALSE"));
    }

    public static void testPalindromeString(String str) {
        System.out.println(String.format("str %s is palindrome : %s", str,
                isPalindromeString(str) ? "TRUE" : "FALSE"));

    }
}
