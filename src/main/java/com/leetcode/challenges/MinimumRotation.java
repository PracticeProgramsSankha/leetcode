package com.leetcode.challenges;

/**
 * @author sanray on 12/9/2021
 */
public class MinimumRotation {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    /**
     * [2,1,1,3,2,1,2,2,1]
     * [3,2,3,1,3,2,3,3,2]
     * o/p : -1
     */
    private static void test1() {
        System.out.println(
                minDominoRotations(new int[] { 2, 1, 1, 3, 2, 1, 2, 2, 1 }, new int[] { 3, 2, 3, 1, 3, 2, 3, 3, 2 }));
    }

    /**
     * [2,1,2,4,2,2]
     * [5,2,6,2,3,2]
     * [1,1,1,1,1,1,1,1]
     * [1,1,1,1,1,1,1,1]
     * [3,5,1,2,3]
     * [3,6,3,3,4]
     */
    private static void test2() {
        System.out.println(minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
    }

    /**
     * [1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,1,1,1,1,1,2,1,2,2,1,1,2,2,2,2,2,1,1,2,2,2,2,1,2,1,1,2,1,1,1,1,2,1,2,2,2,1,2,1,2,2,1,2,1,2]
     * [2,1,1,1,2,1,2,1,2,2,1,1,1,2,1,2,2,1,2,2,2,1,2,2,1,1,1,2,1,2,2,1,2,1,1,2,1,1,1,2,1,2,2,2,2,1,2,1,1,2,1,2,2,1,2,1,1,2,2,1,2,1,1,2]
     * @param tops
     * @param bottoms
     * @return
     */

    private static void test3() {
        System.out.println(minDominoRotations(new int[] {
                        1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,1,1,1,1,1,2,1,2,2,1,1,2,2,2,2,2,1,1,2,2,2,2,1,2,1,1,2,1,1,1,1,2,1,2,2,2,1,2,1,2,2,1,2,1,2 },
                new int[] {
                        2,1,1,1,2,1,2,1,2,2,1,1,1,2,1,2,2,1,2,2,2,1,2,2,1,1,1,2,1,2,2,1,2,1,1,2,1,1,1,2,1,2,2,2,2,1,2,1,1,2,1,2,2,1,2,1,1,2,2,1,2,1,1,2
        }));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int length = tops.length;
        if (length == 0) {
            return -1;
        }

        final int top = tops[0];
        final int bottom = bottoms[0];
        boolean[] topRotate = new boolean[length];
        boolean[] bottomRotate = new boolean[length];
        int iTopRotate = 0;
        int iBottomRotate = 0;
        boolean topExist = true;
        boolean bottomExist = true;
        for (int i = 1; i < length; i++) {
            if (tops[i] == bottoms[i] && (top == tops[i] || bottom == bottoms[i])) {
                continue;
            }
            if (top == tops[i] || top == bottoms[i]) {
                if (top == bottoms[i]) {
                    topRotate[i] = true;
                    iTopRotate++;
                }

            } else {
                topExist = false;
            }
            if (bottom == tops[i] || bottom == bottoms[i]) {
                if (bottom == tops[i]) {
                    bottomRotate[i] = true;
                    iBottomRotate++;
                }
            } else {
                bottomExist = false;
            }

            if (topExist == false && bottomExist == false) {
                return -1;
            }
        }

        if (topExist && bottomExist) {
            return Math.min(iTopRotate, iBottomRotate);
        } else if (topExist) {
            return iTopRotate;
        } else {
            return iBottomRotate;
        }
    }
}
