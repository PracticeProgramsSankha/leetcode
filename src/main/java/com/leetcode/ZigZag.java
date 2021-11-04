package com.leetcode;

/**
 * @author sanray on 10/31/2021
 */
public class ZigZag {

    public static void main(String[] args) {
        System.out.println(generateZigzag("AB", 1));
        System.out.println(generateZigzag("ABC", 1));
        System.out.println(generateZigzag("ABC", 2));
        System.out.println(generateZigzag("PAYPALISHIRING", 3));
        System.out.println(generateZigzag("PAYPALISHIRING", 4));
    }

    public static String generateZigzag(String s, int numRows) {
        if (s == null || s.length() == 1 || numRows >= s.length() || numRows == 1) {
            return s;
        }

        int direction = -1;
        int row = 0;
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            if (row == 0 || row == numRows - 1) {
                direction *= -1;
            }
            stringBuilders[row].append(s.charAt(i));
            row += direction;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(stringBuilders[i].toString());
        }
        return res.toString();

    }
}
