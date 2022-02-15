package com.leetcode.challenges;

/**
 * @author sanray on 11/25/2021
 */
public class ExcelSheetToColumnNumber {

    public static void main(String[] args) {

        System.out.println(titleToNumber("ZA") + " should be 677");
        System.out.println(titleToNumber("A") + " should be 1");
        System.out.println(titleToNumber("AB") + " should be 28");
        System.out.println(titleToNumber("ZY") + " should be 701");
        System.out.println(titleToNumber("FXSHRXW") + " should be 2147483647");
    }

    public static int titleToNumber(String columnTitle) {
        int column = 0;
        for (Character c : columnTitle.toCharArray()) {
            int col = (c - 'A' + 1);
            column = (column * 26) + col;
        }

        return column;

    }
}
