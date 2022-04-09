package com.leetcode.challenges;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/decode-ways/
 *
 * @author sanray on 3/21/2022
 */
public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays sol = new DecodeWays();
        System.out.println(sol.numDecodings("1012")); //3
        System.out.println(sol.numDecodings("12")); // 2
        System.out.println(sol.numDecodings("226")); //3
        System.out.println(sol.numDecodings("06")); //0
    }

    public int numDecodings(String s) {

        int maxLength = s.length();
        int[] ways = new int[maxLength + 1];
        Arrays.fill(ways, 1);
        for (int i = maxLength - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ways[i] = 0;
            } else {
                ways[i] = ways[i + 1];
            }

            if (i + 1 < maxLength && isInRange(Integer.parseInt(s.substring(i, i + 2)))) {
                ways[i] += ways[i + 2];
            }
        }

        return ways[0];
    }

    private boolean isInRange(final int sub) {
        return sub >= 10 && sub <= 26;
    }

}
