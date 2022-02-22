package com.datastructure.codility;

/**
 * @author sanray on 2/19/2022
 */
public class BinaryGaps {

    public int solution(int N) {
        // write your code in Java SE 8
        boolean prev_one = false;
        int zeros = 0;
        int bits = 31;
        int gaps = 0;
        while (bits >= 0) {
            int current = N & (1 << bits);
            if (current != 0) {
                if (prev_one) {
                    gaps = Math.max(gaps, zeros);
                }
                zeros = 0;
                prev_one = true;
            }
            if (current == 0) {
                zeros++;
            }
            bits--;
        }
        return gaps;
    }

    public static void main(String[] args) {
        BinaryGaps gb = new BinaryGaps();
        System.out.println(gb.solution(
                1610612737));
        System.out.println(gb.solution(
                6291457));
    }
}
