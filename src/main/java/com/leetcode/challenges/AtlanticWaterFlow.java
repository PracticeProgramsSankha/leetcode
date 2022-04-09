package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * Best: https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/1885773/Java-2-Different-Approaches-or
 * -Brute-Force-and-Optimal-or-Beats-99.66-or-DFS
 */
public class AtlanticWaterFlow {
    public static void main(String[] args) {
        AtlanticWaterFlow sol = new AtlanticWaterFlow();
        System.out.println(sol.pacificAtlantic(new int[][] {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        }));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            dfs(heights, Integer.MIN_VALUE, r, 0, pacific);
            dfs(heights, Integer.MIN_VALUE, r, col - 1, atlantic);
        }
        for (int c = 0; c < col; c++) {
            dfs(heights, Integer.MIN_VALUE, 0, c, pacific);
            dfs(heights, Integer.MIN_VALUE, row - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights, int prevValue, int r, int c, boolean[][] visited) {

        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited[r][c]
                || heights[r][c] < prevValue) {
            return;
        }

        visited[r][c] = true;

        int currHeight = heights[r][c];
        dfs(heights, currHeight, r - 1, c, visited);
        dfs(heights, currHeight, r + 1, c, visited);
        dfs(heights, currHeight, r, c - 1, visited);
        dfs(heights, currHeight, r, c + 1, visited);
    }
}
