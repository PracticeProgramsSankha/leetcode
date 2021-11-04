package com.leetcode.challenges;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author sanray on 10/20/2021
 */
public class Challenge3Test {
    Challenge3 challenge = new Challenge3();

    @Test
    public void test1() {
        String test = "abcabcbb";
        Assert.assertEquals(test, 3, challenge.lengthOfLongestSubstring(test));
    }

    @Test
    public void test2() {
        String test = "bbbbb";
        Assert.assertEquals(test, 1, challenge.lengthOfLongestSubstring(test));
    }

    @Test
    public void test3() {
        String test = "pwwkew";
        Assert.assertEquals(test, 3, challenge.lengthOfLongestSubstring(test));
    }

    @Test
    public void test3a() {
        String test = "dvdf";
        Assert.assertEquals(test, 3, challenge.lengthOfLongestSubstring(test));
    }

    @Test
    public void test4() {
        String test = "";
        Assert.assertEquals(test, 0, challenge.lengthOfLongestSubstring(test));
    }

    @Test
    public void test5() {
        String test = "ohvhjdml";
        Assert.assertEquals(test, 6, challenge.lengthOfLongestSubstring(test));
    }

}
