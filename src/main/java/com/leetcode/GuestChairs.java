package com.leetcode;

/**
 *
 *
 * There are n guests who are invited to a party. The k-th guest will attend the party at time S[k] and leave the
 * party at time E[k].
 *
 * Given an integer array S and an integer array E, both of length n, return an integer denoting the minimum number
 * of chairs you need such that everyone attending the party can sit down.
 *
 * Example:
 *
 * Input: S = [1, 2, 6, 5, 3], E = [5, 5, 7, 6, 8]
 * Output: 3
 * Explanation:
 * There are five guests attending the party.
 * The 1st guest will arrive at time 1. We need one chair at time 1.
 * The 2nd guest will arrive at time 2. There are now two guests at the party, so we need two chairs at time 2.
 * The 5th guest will arrive at time 3. There are now three guests at the party, so we need three chairs at time 3.
 * The 4th guest will arrive at time 5 and, at the same moment, the 1st and 2nd guests will leave the party.
 * There are now two (the 4th and 5th) guests at the party, so we need two chairs at time 5.
 * The 3rd guest will arrive at time 6, and the 4th guest will leave the party at the same time.
 * There are now two (the 3rd and 5th) guests at the party, so we need two chairs at time 6.
 * So we need at least 3 chairs.
 *
 * Related Problem: https://leetcode.com/problems/meeting-rooms-ii (premium)
 * @author sanray on 11/6/2021
 */
public class GuestChairs {
    public static void main(String[] args) {

        System.out.println(findMaxChairs(new int[] { 1, 2, 6, 5, 3 }, new int[] { 5, 5, 7, 6, 8 }));
    }

    public static int findMaxChairs(int[] S, int[] E) {
        if (S.length <= 1) {
            return S.length;
        }

        int maxChair = 1;
        int maxLeavingTime = E[0];
        for (int i = 1; i < S.length; i++) {
            if (E[i] > maxLeavingTime) {
                maxLeavingTime = E[i];
                maxChair++;
            } else if (S[i] == maxLeavingTime) {
                maxChair--;
            }
        }

        return maxChair;

    }
}
