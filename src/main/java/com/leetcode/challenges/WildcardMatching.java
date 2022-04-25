package com.leetcode.challenges;

import org.junit.Assert;


/**
 * https://leetcode.com/problems/wildcard-matching/
 * @author sanray on 4/25/2022
 */
public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching sol = new WildcardMatching();

        Assert.assertEquals("TEST1", false, sol.isMatch("leetcode", "*e*t?d*"));

        Assert.assertEquals("TEST1", true, sol.isMatch(
                "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
        Assert.assertEquals("TEST1", false, sol.isMatch("aa", "p"));
        Assert.assertEquals("TEST2", true, sol.isMatch("aa", "*"));
        Assert.assertEquals("TEST3", false, sol.isMatch("cb", "?a"));

        System.out.println("ALL TEST PASSED!!");
    }

    final static char SINGLE_MATCH = '?';
    final static char SEQUENCE_MATCH = '*';
    boolean[][][] visited;

    public boolean isMatch(String s, String p) {
        visited = new boolean[s.length()][p.length()][2];
        return helper(s, 0, p, 0);
    }

    public boolean helper(String source, int sIndex, String pattern, int pIndex) {
        // Skip till we dont have * wildcards
        if (sIndex == source.length()) {
            while (pIndex < pattern.length()) {
                if (pattern.charAt(pIndex++) != SEQUENCE_MATCH) {
                    return false;
                }
            }
            return true;
        }

        if (pIndex >= pattern.length()) {
            return false;
        }

        if (visited[sIndex][pIndex][0] == true) {
            return visited[sIndex][pIndex][1];
        }

        visited[sIndex][pIndex][0] = true;

        final char wildCard = pattern.charAt(pIndex);

        if (wildCard == SINGLE_MATCH || wildCard == source.charAt(sIndex)) {
            return visited[sIndex][pIndex][1] = helper(source, sIndex + 1, pattern, pIndex + 1);
        } else if (pattern.charAt(pIndex) == SEQUENCE_MATCH) {
            // There can be 2 possibilities
            return visited[sIndex][pIndex][1] = helper(source, sIndex + 1, pattern, pIndex) ||
                    helper(source, sIndex, pattern, pIndex + 1);
        }

        return false;
    }

}
