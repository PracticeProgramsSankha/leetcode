package com.leetcode.challenges;

import java.util.HashMap;


/**
 * @author sanray on 10/31/2021
 */
public class Atoi {
    public static void main(String[] args) {
/*
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("-42in work"));
        System.out.println(myAtoi("0012"));
        System.out.println(myAtoi("999999999999999999"));
        System.out.println(myAtoi("-999999999999999999"));

        System.out.println(myAtoi("words in 123"));*/
        System.out.println(myAtoi(".1"));
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int counter = 0;
        boolean isPositive = true;
        while (counter < s.length() && isNan(s.charAt(counter))) {
            if(s.charAt(counter) == '+') {
                isPositive = true;
                counter++;
            } else if(s.charAt(counter) == '-') {
                isPositive = false;
                counter++;
            }
            break;
        }

        int collector = 0;
        for (int i = counter; i < s.length(); i++) {
            if (isNan(s.charAt(i))) {
                break;
            }
            int number = getNumber(s.charAt(i));
            if (collector > (Integer.MAX_VALUE - number) / 10) {
                return isPositive? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            collector = collector * 10 + number;

        }

        return isPositive ? collector : -collector;

    }

    private static boolean isNan(final char charAt) {
        int number = getNumber(charAt);
        return !(number >= 0 && number <= 9);
    }

    private static int getNumber(final char charAt) {
        return charAt - 48;
    }
}
