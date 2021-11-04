package com;

import org.junit.Assert;
import org.junit.Test;
import com.leetcode.turbulance.Solution;


/**
 * @author sanray on 9/24/2021
 */
public class TurbulanceTest {

    private Solution solution = new Solution();

    @Test
    public void test1() {
        int[] numbers = {9,4,2,10,7,8,8,1,9};
        Assert.assertEquals(5, solution.maxTurbulenceSize(numbers));
    }

    @Test
    public void test2() {
        int[] numbers = {4,8,12,16};
        Assert.assertEquals(2, solution.maxTurbulenceSize(numbers));
    }

    @Test
    public void test3() {
        int[] numbers = {4,8,12,16};
        Assert.assertEquals(1, solution.maxTurbulenceSize(numbers));
    }
}
