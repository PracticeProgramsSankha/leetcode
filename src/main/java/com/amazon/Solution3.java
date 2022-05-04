package com.amazon;
/*
 * Floodfill
 */

/*
0 1 0 0 1 (2,2) 0 1 2 2 1
1 1 0 0 1  ==>  1 1 2 2 1
0 1 0 0 0       0 1 2 2 2
1 0 1 0 1       1 0 1 2 1
*/

import com.datastructure.Utility;


public class Solution3 {
    public static void main(String args[]) {

        test1();
    }

    private static void test1() {
        Solution3 sol = new Solution3();
        int[][] matrix = new int[][] {
                { 0, 1, 0, 0, 1 },
                { 1, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        Utility.print2DArray("before", matrix);
        sol.floodfill(matrix, new int[] { 2, 2 }, 2);
        Utility.print2DArray("before", matrix);
    }

    public void floodfill(int[][] matrix, int[] pos, int targetColor) {
        int originalColor = matrix[pos[0]][pos[1]];
        floodfillInternal(matrix, pos, originalColor, targetColor);
    }

    public void floodfillInternal(int[][] matrix, int[] pos, int orignalColor, int targetColor) {
        // Avalaiblecirection
        int[][] directions = new int[][] {
                { -1, 0 },
                { 1, 0 },
                { 0, 1 },
                { 0, -1 }
        };

        int curr_x = pos[0];
        int curr_y = pos[1];
        if (curr_x < 0 || curr_x >= matrix.length || curr_y < 0 || curr_y >= matrix[0].length) {
            return;
        }
        // comments
        if (matrix[curr_x][curr_y] != orignalColor) {
            return;
        }

        matrix[curr_x][curr_y] = targetColor;
        for (int[] dir : directions) {
            floodfillInternal(matrix, new int[] { curr_x + dir[0], curr_y + dir[1] }, orignalColor, targetColor);
        }

    }
}
