package com.leetcode.challenges;

import java.util.Stack;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
 * https://www.youtube.com/watch?v=zx5Sw9130L0
 * @author sanray on 4/26/2022
 */
public class LargestTriangleInHistogram {

    public static void main(String[] args) {
        LargestTriangleInHistogram sol = new LargestTriangleInHistogram();
        Assert.assertEquals("TEST1", 10, sol.largestRectangleArea(new int[]
                { 2, 1, 5, 6, 2, 3 }));
        Assert.assertEquals("TEST2", 4, sol.largestRectangleArea(new int[]
                { 2, 4 }));

        System.out.println("All test passed!!");

    }

    public int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            // Whenever the top element height is greater than current height, it can't extend further, hence remove
            // it from stack, and also keep  the start of the prev height and push it (index, new_h) eventually into
            // stack
            while (!stack.empty() && stack.peek()[1] > heights[i]) {
                int[] hMap = stack.pop();
                maxArea = Math.max(maxArea, hMap[1] * (i - hMap[0]));
                start = hMap[0];
            }
            stack.push(new int[] { start, heights[i] });
        }

        // There would be few entries left in stack, compute the maxArea for those elements as well.
        while (!stack.empty()) {
            int[] hMap = stack.pop();
            maxArea = Math.max(maxArea, hMap[1] * (heights.length - hMap[0]));
        }

        return maxArea;

    }
}
