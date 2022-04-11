package com.leetcode.challenges;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author sanray on 3/4/2022
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();
        System.out.println(sol.longestPalindrome("babad")); // bab
        System.out.println(sol.longestPalindrome("cbbd")); // bb
    }

    private String longestPalindrome(final String inputString) {
        if( inputString == null || inputString.isEmpty())
            return inputString;
        int max = 0;
        String result = "";
        for( int i = 0; i < inputString.length(); i++) {
            int odd = getLength(inputString, i, i);
            int even = getLength(inputString, i, i+1);
            odd = Math.max(odd,even);
            if( odd > max) {
                max = odd;
                result = inputString.substring(i-(odd-1)/2, i+odd/2+1);
            }
        }
        return result;
    }

    private int getLength(String s, int start,int end) {
        while( start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end) ) {
            --start;
            ++end;
        }
        return end-start-1;
    }
}
