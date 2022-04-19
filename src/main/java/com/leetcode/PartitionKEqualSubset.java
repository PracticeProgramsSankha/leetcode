package com.leetcode;

import java.util.Arrays;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionKEqualSubset {
    public static void main(String[] args) {
        PartitionKEqualSubset sol = new PartitionKEqualSubset();
        Assert.assertEquals("TEST3", false, sol.canPartitionKSubsets(new int[] { 2, 2, 2, 2, 3, 4, 5 }, 4));
        Assert.assertEquals("TEST1", true, sol.canPartitionKSubsets(new int[] { 4, 3, 2, 3, 5, 2, 1 }, 4));
        Assert.assertEquals("TEST2", false, sol.canPartitionKSubsets(new int[] { 1, 2, 3, 4 }, 3));

        System.out.println("All test passed..");

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int totalSum = Arrays.stream(nums).reduce(0, (left, right) -> left + right);
        if (totalSum % k != 0) {
            // Can't equally divide
            return false;
        }
        // Sort to minimize iteration
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        int target = totalSum / k;
        return backTrack(nums, 0, nums.length, k, 0, target, visited);

    }

    private boolean backTrack(final int[] nums, final int startIndex, final int endIndex, final int k,
            final int subSetSum, final int target, final boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (subSetSum == target) {
            return backTrack(nums, 0, nums.length, k - 1, 0, target, visited);
        }

        for (int i = startIndex; i < endIndex; i++) {
            if (visited[i] || subSetSum + nums[i] > target) {
                // Subset sum is exceeding
                continue;
            }
            visited[i] = true;
            if (backTrack(nums, i + 1, endIndex, k, subSetSum + nums[i], target, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

}
