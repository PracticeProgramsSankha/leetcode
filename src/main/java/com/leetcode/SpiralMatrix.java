package com.leetcode;

import java.util.ArrayList;
import java.util.List;


/** https://leetcode.com/problems/spiral-matrix/submissions/
 * @author sanray on 3/19/2022
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix sol = new SpiralMatrix();
        System.out.println(sol.spiralOrder(new int[][] {
                { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }
        }));
    }

    enum DIRECTION {
        RIGHT(0,1),
        LEFT(0,-1),
        DOWN(1,0),
        UP(-1,0);

        private final int r, c;

        DIRECTION(final int r, final int c) {
            this.r = r;
            this.c = c;
        }
    }
    private List<Integer> spiralOrder(final int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[row][col];

        int currentRow=0,currentCol=0,currentDirection=0;
        int visitedCellCount = 0;
        int totalCount = row * col;

        final List<Integer> result = new ArrayList<>();
        while(visitedCellCount < totalCount){
            result.add(matrix[currentRow][currentCol]);
            visitedCellCount++;
            visited[currentRow][currentCol] = true;

            int newRow = currentRow + dirs[currentDirection][0];
            int newCol = currentCol + dirs[currentDirection][1];

            if(!(newRow>=0 && newRow<row && newCol>=0 && newCol<col) || visited[newRow][newCol]){
                currentDirection++;
                currentDirection = currentDirection%4;
                newRow = currentRow + dirs[currentDirection][0];
                newCol = currentCol + dirs[currentDirection][1];
            }

            currentRow = newRow;
            currentCol = newCol;
        }

        return result;
    }


}
