package com.leetcode.challenges;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * https://leetcode.com/problems/dungeon-game/
 *
 * @author sanray on 12/15/2021
 */
public class DungeonGame {
    public static void main(String[] args) {

        test1();
    }

    private static void test1() {
        System.out.println(calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
    }

    public static int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MIN_VALUE;
            }
        }
        int health = backtrack(dungeon, 0, 0);
        return 1 + health;
    }

    public static int backtrack(int[][] dungeon, int r, int c) {
        if (r >= dungeon.length || c >= dungeon[0].length) {
            return Integer.MAX_VALUE;
        }

        // Reached to princess
        if (r == dungeon.length - 1 && c == dungeon[0].length - 1) {
            return Math.max(0, -dungeon[r][c]);
        }

        // go right and check
        int right = backtrack(dungeon, r, c + 1);
        // go down and check
        int down = backtrack(dungeon, r + 1, c);
        return Math.max(0, -dungeon[r][c] + Math.min(right, down));
    }
}
