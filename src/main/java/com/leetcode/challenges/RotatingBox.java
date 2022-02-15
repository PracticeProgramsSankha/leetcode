package com.leetcode.challenges;

import java.util.Stack;


/**
 * https://leetcode.com/problems/rotating-the-box/
 *
 * @author sanray on 11/14/2021
 */
public class RotatingBox {
    public static void main(String[] args) {

        test2();
        test1();

    }

    private static void test1() {
        char[][] box = new char[][] {
                { '#', '.', '#' }
        };
        printBox("Original", box, 1, 3);
        char[][] rotatedBox = rotateTheBox(box);
        //printBox(rotatedBox, 3, 1);
    }

    private static void test2() {
        char[][] box = new char[][] {
                { '#', '#', '*', '.', '*', '.' },
                { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' }
        };
        printBox("Original", box, 3, 6);
        char[][] rotatedBox = rotateTheBox(box);
        printBox("Rotated", rotatedBox, 6, 3);
    }

    private static void printBox(String msg, final char[][] box, final int m, final int n) {
        System.out.println(msg + " box");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotatedBox = new char[n][m];
        // Rotate 90deg
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedBox[i][j] = box[m - 1 - j][i];
            }
        }

        //printBox("Rotated", rotatedBox, n, m);

        // Check Bottom up;
        char stone = '#';
        char empty = '.';
        char obstable = '*';
        for (int i = 0; i < m; i++) {
            int fallIndex = -1;
            for (int column = 0; column < n; column++) {
                if (rotatedBox[column][i] == stone && fallIndex == -1) {
                    fallIndex = column;
                } else if (rotatedBox[column][i] == empty && fallIndex != -1) {
                    rotatedBox[fallIndex][i] = empty;
                    rotatedBox[column][i] = stone;
                    fallIndex += 1;
                } else if (rotatedBox[column][i] == obstable && fallIndex != -1) {
                    fallIndex = -1;
                }
                //printBox("Gravity " + column + " " + column, rotatedBox, n, m);
            }
        }
        //printBox("Gravity", rotatedBox, n, m);

        return rotatedBox;

    }
}
