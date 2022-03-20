package com.leetcode;

import java.util.HashSet;
import java.util.Set;


/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * @author sanray on 3/20/2022
 */
public class SetMatrixZero {

    public static void main(String[] args) {
        SetMatrixZero sol = new SetMatrixZero();
        sol.setZeroes(new int[][] {
                { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 }
        });
    }

    public void setZeroes(int[][] matrix) {
        print2dMat(matrix);
        int maxRows = matrix.length;
        int maxCols = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Now clear it
        for (int key : rows) {
            for (int i = 0; i < maxCols; i++) {
                matrix[key][i] = 0;
            }
        }
        // Now clear it
        for (int key : cols) {
            for (int i = 0; i < maxRows; i++) {
                matrix[i][key] = 0;
            }
        }

        print2dMat(matrix);

    }

    public void print2dMat(int[][] matrix) {
        System.out.println("matrix===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
