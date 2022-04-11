package com.leetcode.challenges;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/palindromic-substrings/submissions/
 * https://www.youtube.com/watch?v=4RACzI5-du8
 */

public class PalindromicSubString {

    public static void main(String[] args) {
        PalindromicSubString sol = new PalindromicSubString();
        Assert.assertEquals("abc", 3, sol.countSubstrings("abc"));
        Assert.assertEquals("aaa", 6, sol.countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // For Odd Index Start Left & Right at same position and check its left and right
            res += isPalindrome(s, i, i);
            // For Even Index Start Left & Right = Left+1 at same position and check its left and right
        }
        return res;
    }

    private int isPalindrome(final String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}
