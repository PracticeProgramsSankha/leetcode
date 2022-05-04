package com.leetcode.tictactoe;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author sanray on 9/22/2021
 */
public class Solution3Test {

    @Test
    public void test1() {
        int[][] moves = { { 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 2, 2 } };
        Assert.assertEquals("A", Solution.tictactoe(moves));
    }

    @Test
    public void test2() {
        int[][] moves = { { 0, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 2, 0 } };
        Assert.assertEquals("B", Solution.tictactoe(moves));
    }

    @Test
    public void test3() {
        int[][] moves = { { 0, 0 }, { 1, 1 }, { 2, 0 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 0, 1 }, { 0, 2 }, { 2, 2 } };
        Assert.assertEquals("Draw", Solution.tictactoe(moves));
    }

    @Test
    public void test4() {
        int[][] moves = { { 0, 0 }, { 1, 1 } };
        Assert.assertEquals("Pending", Solution.tictactoe(moves));
    }

    @Test
    public void test5() {
        int[][] moves = { { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 0 }, { 0, 1 }, { 2, 0 }, { 1, 1 } };
        Assert.assertEquals("A", Solution.tictactoe(moves));
    }

    @Test
    public void test6() {
        int[][] moves = { { 2, 0 }, { 1, 1 }, { 0, 2 }, { 2, 1 }, { 1, 2 }, { 1, 0 }, { 0, 0 }, { 0, 1 } };
        Assert.assertEquals("B", Solution.tictactoe(moves));
    }

}
