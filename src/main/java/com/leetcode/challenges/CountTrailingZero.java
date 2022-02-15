package com.leetcode.challenges;

/**
 * @author sanray on 12/3/2021
 */
public class CountTrailingZero {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
    }

    public static int trailingZeroes(int n) {
        if(n == 0) {
            return 0;
        }

        int fact1 = fact(n);
        int count = 0;
        while(fact1%10 == 0) {
            count++;
            fact1/=10;
        }

        return count;

    }

    public static int fact(int n) {
        int result = 1;
        for(int i=1; i <= n; i++) {
            result = result *i;
        }
        return result;
    }
}
