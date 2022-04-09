package com.leetcode.challenges;

import java.util.Arrays;


/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();
        System.out.println(sol.uniquePaths(1, 1));
        System.out.println(sol.uniquePaths(3, 7));
        System.out.println(sol.uniquePaths(3, 2));
        System.out.println(sol.uniquePaths(100, 100));

    }

    public int uniquePaths(int m, int n) {
        int[][] reached = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(reached[i], 0);
        }
        dfs(m - 1, n - 1, reached);

        return reached[m - 1][n - 1];

    }

    public int dfs(int m, int n, int[][] reached) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            reached[m][n] = 1;
            return reached[m][n];
        }
        if (reached[m][n] != 0) {
            return reached[m][n];
        }
        reached[m][n] = dfs(m - 1, n, reached) + dfs(m, n - 1, reached);
        return reached[m][n];
    }
}
