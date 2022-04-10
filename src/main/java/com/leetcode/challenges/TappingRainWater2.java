package com.leetcode.challenges;

import java.util.PriorityQueue;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * 04/11/2022
 */
public class TappingRainWater2 {
    public static void main(String[] args) {
        TappingRainWater2 sol = new TappingRainWater2();
        Assert.assertEquals("test1", 4, sol.trapRainWater(new int[][] {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        }));
        System.out.println("All test Passed");
    }

    class Coord implements Comparable<Coord> {

        int x;
        int y;
        int h;

        Coord(final int x, final int y, final int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override public int compareTo(final Coord o) {
            return this.h - o.h;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Coord> boundary = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    boundary.offer(new Coord(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int[][] direction = new int[][] {
                { 0, 1 },
                { 0, -1 },
                { -1, 0 },
                { 1, 0 }
        };
        int water = 0;
        while (!boundary.isEmpty()) {
            Coord coord = boundary.poll();
            for (int[] dir : direction) {
                int newX = coord.x + dir[0];
                int newY = coord.y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    if (heightMap[newX][newY] < coord.h) {
                        water += coord.h - heightMap[newX][newY];
                    }
                    boundary.offer(new Coord(newX, newY, Math.max(coord.h, heightMap[newX][newY])));
                    visited[newX][newY] = true;
                }
            }
        }

        return water;

    }
}
