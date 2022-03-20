package com.leetcode.challenges;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * @author sanray on 3/19/2022
 */
public class JumpGame {
    public static void main(String[] args) {
        JumpGame sol = new JumpGame();
        System.out.println(sol.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(sol.canJump(new int[] { 3, 2, 1, 0, 4 }));
        System.out.println(sol.canJump(new int[] { 2, 0 }));
    }

    public boolean canJump(int[] nums) {
        int number = nums[0];

        for(int i = 1; i<nums.length; i++){
            //If previous number was 0 , we can't reach the current place
            if(number == 0) return false;

            int currNumber = nums[i];

            //Take max of current number and (previous number -1).
            //-1 because we spend 1 from number in-order to travel to current place
            if(number-1 <=currNumber) {
                number = currNumber;
            } else {
                number--;
            }

        }
        return true;

    }
}
