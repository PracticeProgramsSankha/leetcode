package com.leetcode.challenges;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/house-robber/
 * <p>
 * Exp: https://www.youtube.com/watch?v=73r3KWiEvyk&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO
 */
public class HouseRobber {

    public static void main(String[] args) {

        HouseRobber sol = new HouseRobber();
        Assert.assertEquals("test1", 4, sol.rob(new int[] { 1, 2, 3, 1 }));

        System.out.println("All test Passed");

    }

    public int rob(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        // No adjacent houses can be robbed
        // If house1 is robbed then find max of house1 & house3...n
        // if house2 is robbed then find max of house2 & house4..n
        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;

    }
}
