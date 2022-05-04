package com.leetcode.challenges;

import org.junit.Assert;


/**
 * @author sanray on 5/2/2022
 */
public class EditDistance {

    public static void main(String[] args) {
        EditDistance sol = new EditDistance();
        Assert.assertEquals(3, sol.editDistance("saturday", "sunday"));
        Assert.assertEquals(1, sol.editDistance("cat", "cut"));
        Assert.assertEquals(1, sol.editDistance("geek", "gesek"));
        Assert.assertEquals(0, sol.editDistance("sankha", "sankha"));

        System.out.println("All test passed!");
    }

    private int editDistance(final String str1, final String str2) {
        return findEditDistance(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    private int findEditDistance(final String str1, final String str2, final int m, final int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        if (str1.charAt(m) == str2.charAt(n)) {
            return findEditDistance(str1, str2, m - 1, n - 1);
        } else {
            return 1 + findMinimum(
                    findEditDistance(str1, str2, m, n - 1), // Insert
                    findEditDistance(str1, str2, m - 1, n), // Remove
                    findEditDistance(str1, str2, m - 1, n - 1) // Replace
            );
        }
    }

    private int findMinimum(final int... vars) {
        int min = Integer.MAX_VALUE;
        for (int v : vars) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }
}
