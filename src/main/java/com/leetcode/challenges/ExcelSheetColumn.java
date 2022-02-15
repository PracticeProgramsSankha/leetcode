package com.leetcode.challenges;

/**
 * @author sanray on 11/15/2021
 */
public class ExcelSheetColumn {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle(52));
    }

    public static String convertToTitle(int columnNumber) {

        return getTitle(columnNumber);

    }

    public static String getTitle(int n) {
        if(n <= 26) {
            return Character.toString((char) ('A' + n - 1));
        }

        return getTitle(n/26-1) +  getTitle(n-26);

    }
}
